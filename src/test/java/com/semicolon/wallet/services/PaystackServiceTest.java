package com.semicolon.wallet.services;


import com.semicolon.wallet.dtos.request.InitializeTransactionRequest;
import com.semicolon.wallet.dtos.response.InitializeTransactionResponse;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaystackServiceTest {

    @Autowired
    private PaystackService paystackService;


    @Test
    void initializeTransactionTest(){
        InitializeTransactionRequest initializeTransactionRequest = new InitializeTransactionRequest();
        initializeTransactionRequest.setAmount(BigDecimal.valueOf(3000));
        initializeTransactionRequest.setEmail("qudusa55@gmail.com");
        InitializeTransactionResponse response =
                paystackService.initializeTransaction(initializeTransactionRequest);
        assertThat(response).isNotNull();

    }

}
