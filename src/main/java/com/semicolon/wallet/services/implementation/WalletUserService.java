package com.semicolon.wallet.services.implementation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.semicolon.wallet.data.models.User;
import com.semicolon.wallet.data.repositories.UserRepository;
import com.semicolon.wallet.dtos.request.CreateWalletRequest;
import com.semicolon.wallet.exceptions.UserAlreadyExistException;
import com.semicolon.wallet.services.UserService;
import com.semicolon.wallet.utils.Validation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.wallet.utils.Validation.validateUserDetails;


@Service
public class WalletUserService implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createProfile(CreateWalletRequest request) throws UserAlreadyExistException, NumberParseException {
        validateUserDetails(request);
        if (userExist(request.getEmail())) throw new UserAlreadyExistException
                ("Account With These Credentials Exist");
        User user = modelMapper.map(request,User.class);
        userRepository.save(user);
        return user;
    }

    @Override
    public User findUser(String accountNumber) {
        return userRepository.findUserByPhoneNumber(accountNumber);
    }

    private boolean userExist(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }
}
