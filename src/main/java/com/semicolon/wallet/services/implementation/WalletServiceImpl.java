package com.semicolon.wallet.services.implementation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.semicolon.wallet.data.models.User;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.dtos.request.FundWalletRequest;
import com.semicolon.wallet.dtos.request.InitializeTransactionRequest;
import com.semicolon.wallet.dtos.response.CreateWalletResponse;
import com.semicolon.wallet.dtos.response.FundWalletResponse;
import com.semicolon.wallet.dtos.response.InitializeTransactionResponse;
import com.semicolon.wallet.services.PaystackService;
import com.semicolon.wallet.services.UserService;
import com.semicolon.wallet.services.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private UserService userService;
    @Autowired
    private PaystackService paystackService;


    @Override
    public CreateWalletResponse createAccount(CreateWalletRequest request) throws NumberParseException {
        User user = userService.createProfile(request);
        CreateWalletResponse response = new CreateWalletResponse();
        response.setAccountNumber(user.getPhoneNumber());
        return response;
    }

    @Override
    public FundWalletResponse fundWallet(FundWalletRequest fundWalletRequest) {
        InitializeTransactionRequest initializeTransactionRequest = setInitializeTransaction(fundWalletRequest);
        InitializeTransactionResponse response = paystackService.initializeTransaction(initializeTransactionRequest);

        return null;
    }

    private InitializeTransactionRequest setInitializeTransaction(FundWalletRequest fundWalletRequest) {
        InitializeTransactionRequest initializeTransactionRequest = new InitializeTransactionRequest();
        initializeTransactionRequest.setEmail(fundWalletRequest.getEmail());
        initializeTransactionRequest.setAmount(fundWalletRequest.getAmount());
        return initializeTransactionRequest;
    }
}
