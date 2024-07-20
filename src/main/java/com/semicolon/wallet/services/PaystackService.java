package com.semicolon.wallet.services;

import com.semicolon.wallet.dtos.request.InitializeTransactionRequest;
import com.semicolon.wallet.dtos.response.InitializeTransactionResponse;

public interface PaystackService {

    InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest initializeTransactionRequest);
}
