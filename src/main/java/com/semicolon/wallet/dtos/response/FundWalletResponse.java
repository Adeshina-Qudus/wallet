package com.semicolon.wallet.dtos.response;


import com.semicolon.wallet.data.models.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class FundWalletResponse {

    private BigDecimal accountBalance;
    private String description;
    private Status status ;
    private LocalDateTime createdAt;
}
