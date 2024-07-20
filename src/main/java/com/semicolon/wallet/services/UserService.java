package com.semicolon.wallet.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.semicolon.wallet.data.models.User;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.exceptions.UserAlreadyExistException;

public interface UserService {
    User createProfile(CreateWalletRequest request) throws UserAlreadyExistException, NumberParseException;
}
