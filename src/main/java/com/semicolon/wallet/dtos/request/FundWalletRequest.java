package com.semicolon.wallet.dtos.request;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class FundWalletRequest {

    private String email;
    private BigDecimal amount;
    private String description;

}
