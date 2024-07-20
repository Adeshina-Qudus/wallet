package com.semicolon.wallet.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaystackTransactionDetails {

    @JsonProperty("authorization_url")
    private String authorizationUrl;
    private String reference;
}
