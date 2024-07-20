package com.semicolon.wallet.exceptions;

public class UserAlreadyExistException extends WalletException {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
