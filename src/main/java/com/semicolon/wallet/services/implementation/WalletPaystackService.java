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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class WalletPaystackService implements PaystackService {

    @Autowired
    private BeanConfig beanConfig;
    @Autowired
    private WalletService walletService;

    @Override
    public InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest
                                                                           initializeTransactionRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<InitializeTransactionRequest> transactionRequest = buildInitializer(initializeTransactionRequest);
        ResponseEntity<InitializeTransactionResponse> response = restTemplate.postForEntity(
                beanConfig.getPaystackInitializeUrl(),
                transactionRequest, InitializeTransactionResponse.class);
        return response.getBody();
    }

    private HttpEntity<InitializeTransactionRequest> buildInitializer(InitializeTransactionRequest
                                                                              initializeTransactionRequest) {
        InitializeTransactionRequest transactionRequest = new InitializeTransactionRequest();
        transactionRequest.setEmail(initializeTransactionRequest.getEmail());
        transactionRequest.setAmount(initializeTransactionRequest.getAmount().
                multiply(BigDecimal.valueOf(100)));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer "+beanConfig.getPaystackApiKey());
        return new HttpEntity<>(transactionRequest,headers);
    }
}
