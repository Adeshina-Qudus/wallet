package com.semicolon.wallet.dtos.request;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Setter
@Getter
public class InitializeTransactionRequest {

    private BigDecimal amount;
    private String email;
}
