package com.semicolon.wallet.dtos.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InitializeTransactionResponse {

    private boolean status;
    private PaystackTransactionDetails data;
}
