package com.semicolon.wallet.services;

import com.semicolon.wallet.data.models.Transaction;
import com.semicolon.wallet.data.models.Wallet;
import com.semicolon.wallet.dtos.request.FundWalletRequest;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction, FundWalletRequest fundWalletRequest, Long id, Wallet wallet);
}
