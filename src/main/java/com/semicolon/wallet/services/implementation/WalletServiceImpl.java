package com.semicolon.wallet.services.implementation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.semicolon.wallet.data.models.Status;
import com.semicolon.wallet.data.models.Transaction;
import com.semicolon.wallet.data.models.User;
import com.semicolon.wallet.data.models.Wallet;
import com.semicolon.wallet.data.repositories.WalletRepository;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.dtos.request.FundWalletRequest;
import com.semicolon.wallet.dtos.request.InitializeTransactionRequest;
import com.semicolon.wallet.dtos.response.CreateWalletResponse;
import com.semicolon.wallet.dtos.response.FundWalletResponse;
import com.semicolon.wallet.dtos.response.InitializeTransactionResponse;
import com.semicolon.wallet.services.PaystackService;
import com.semicolon.wallet.services.TransactionService;
import com.semicolon.wallet.services.UserService;
import com.semicolon.wallet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private UserService userService;
    @Autowired
    private PaystackService paystackService;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransactionService transactionService;


    @Override
    public CreateWalletResponse createAccount(CreateWalletRequest request) throws NumberParseException {
        User user = userService.createProfile(request);
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setAccountName(user.getFirstName()+" "+user.getLastName());
        wallet.setAccountNumber(user.getPhoneNumber());
        wallet.setAccountBalance(BigDecimal.valueOf(0.0));
        CreateWalletResponse response = new CreateWalletResponse();
        response.setAccountNumber(wallet.getAccountNumber());
        walletRepository.save(wallet);
        return response;
    }

    @Override
    public FundWalletResponse fundWallet(FundWalletRequest fundWalletRequest) {
        User user = userService.findUser(fundWalletRequest.getAccountNumber());
        Wallet wallet = walletRepository.findByAccountNumber(fundWalletRequest.getAccountNumber());
        InitializeTransactionRequest initializeTransactionRequest = setInitializeTransaction(fundWalletRequest,user.getEmail());
        InitializeTransactionResponse response = paystackService.initializeTransaction(initializeTransactionRequest);
        Transaction transaction = new Transaction();
        if (response.isStatus()){
            transaction.setStatus(Status.SUCCESSFUL);
            wallet.setAccountBalance(wallet.getAccountBalance().add(fundWalletRequest.getAmount()));
        }else {
            transaction.setStatus(Status.FAILED);
        }
        Transaction updatedTransaction = transactionService.createTransaction(transaction,fundWalletRequest,
                user.getId(),wallet);
        walletRepository.save(wallet);
        return walletFunded(updatedTransaction);
    }

    private FundWalletResponse walletFunded(Transaction updatedTransaction){
        FundWalletResponse fundWalletResponse = new FundWalletResponse();
        fundWalletResponse.setStatus(updatedTransaction.getStatus());
        fundWalletResponse.setDescription(updatedTransaction.getDescription());
        fundWalletResponse.setCreatedAt(updatedTransaction.getCreatedAt());
        fundWalletResponse.setAccountBalance(updatedTransaction.getAmount());
        return fundWalletResponse;
    }

    private InitializeTransactionRequest setInitializeTransaction(FundWalletRequest fundWalletRequest,String  email) {
        InitializeTransactionRequest initializeTransactionRequest = new InitializeTransactionRequest();
        initializeTransactionRequest.setEmail(email);
        initializeTransactionRequest.setAmount(fundWalletRequest.getAmount());
        return initializeTransactionRequest;
    }
}
