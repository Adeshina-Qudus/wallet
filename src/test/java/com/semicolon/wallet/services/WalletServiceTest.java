package com.semicolon.wallet.services;
import com.google.i18n.phonenumbers.NumberParseException;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.dtos.request.FundWalletRequest;
import com.semicolon.wallet.dtos.response.CreateWalletResponse;
import com.semicolon.wallet.dtos.response.FundWalletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class WalletServiceTest {

    @Autowired
    private WalletService walletService;


    @Test
    void createWalletAccountTest() throws NumberParseException {
        CreateWalletRequest request = new CreateWalletRequest();
        request.setEmail("alimotadeshina03@gmail.com");
        request.setFirstName("Qudus");
        request.setLastName("Adeshina");
        request.setPhoneNumber("08135347913");
        CreateWalletResponse response = walletService.createAccount(request);
        assertThat(response).isNotNull();
    }

    @Test
    void fundWalletTest(){
        FundWalletRequest fundWalletRequest = new FundWalletRequest();
        fundWalletRequest.setAmount(BigDecimal.valueOf(2000));
        fundWalletRequest.setAccountNumber("08135347913");
        fundWalletRequest.setDescription("Owo Sara");
        FundWalletResponse response = walletService.fundWallet(fundWalletRequest);
        assertThat(response).isNotNull();
    }

}
