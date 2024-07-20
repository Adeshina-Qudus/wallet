package com.semicolon.wallet.services;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.dtos.response.CreateWalletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class WalletServiceTest {

    @Autowired
    private WalletService walletService;


    @Test
    void createWalletAccountTest(){

        CreateWalletRequest request = new CreateWalletRequest();
        request.setEmail("qudusa55@gmail.com");
        request.setFirstName("Qudus");
        request.setLastName("Adeshina");
        request.setPhoneNumber("09079447913");
        CreateWalletResponse response = walletService.createAccount(request);
        assertThat(response).isNotNull();
    }

}
