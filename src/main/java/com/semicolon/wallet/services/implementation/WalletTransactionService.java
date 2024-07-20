package com.semicolon.wallet.services.implementation;

import com.semicolon.wallet.data.models.Transaction;
import com.semicolon.wallet.data.models.Wallet;
import com.semicolon.wallet.data.repositories.TransactionRepository;
import com.semicolon.wallet.dtos.request.FundWalletRequest;
import com.semicolon.wallet.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WalletTransactionService implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction, FundWalletRequest fundWalletRequest, Long id, Wallet wallet) {
        transaction.setUserId(id);
        transaction.setAmount(fundWalletRequest.getAmount());
        transaction.setWallet(wallet);
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setDescription(fundWalletRequest.getDescription());
        transactionRepository.save(transaction);
        return transaction;
    }
}
