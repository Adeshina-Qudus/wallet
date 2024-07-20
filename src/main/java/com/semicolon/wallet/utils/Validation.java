package com.semicolon.wallet.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.exceptions.InvalidEmailException;
import com.semicolon.wallet.exceptions.InvalidPhoneNumberException;

public class Validation {
    public static void validateUserDetails(CreateWalletRequest request) throws NumberParseException {
        phoneNumberValidation(request.getPhoneNumber());
        verifyEmail(request.getEmail());

    }
    public static boolean isPhoneNumberValid(String contact) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(contact, "IN");
        return phoneNumberUtil.isValidNumber(phoneNumber);
    }

    public static void phoneNumberValidation(String number) throws InvalidPhoneNumberException, NumberParseException {
        if (!isPhoneNumberValid(number)) {
            throw new InvalidPhoneNumberException("invalid phone number");
        }
    }

    public static void verifyEmail(String email) throws InvalidEmailException {
        if (email == null || email.trim().isEmpty()) {
            throw new InvalidEmailException("email field is empty, kindly provide your email");
        }
        if (!email.matches("[A-z0-9!#$%^&():;.*_~`+{}]+@[a-z]+[.][a-z]{2,3}")){
            throw new InvalidEmailException("email address is not valid");
        }
    }
}
