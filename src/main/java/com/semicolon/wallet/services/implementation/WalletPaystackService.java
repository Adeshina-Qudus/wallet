package com.semicolon.wallet.services.implementation;

import com.semicolon.wallet.config.BeanConfig;
import com.semicolon.wallet.dtos.request.InitializeTransactionRequest;
import com.semicolon.wallet.dtos.response.InitializeTransactionResponse;
import com.semicolon.wallet.services.PaystackService;
import com.semicolon.wallet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WalletPaystackService implements PaystackService {

    @Autowired
    private BeanConfig beanConfig;
    @Autowired
    private WalletService walletService;


    @Override
    public InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest initializeTransactionRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<InitializeTransactionResponse> initializeTransactionResponse = buildInitializeTransaction()
        return null;
    }
}
