package com.semicolon.wallet.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateWalletRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
