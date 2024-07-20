package com.semicolon.wallet.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.dtos.response.CreateWalletResponse;

public interface WalletService {

    CreateWalletResponse createAccount(CreateWalletRequest request) throws NumberParseException;
}
