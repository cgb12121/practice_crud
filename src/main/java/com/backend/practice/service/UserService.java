package com.backend.practice.service;

import com.backend.practice.util.exception.TooManyAttemptsException;
import com.backend.practice.model.dto.UserDto;
import com.backend.practice.model.dto.request.ChangePasswordRequest;
import com.backend.practice.model.dto.request.UserDeleteAccountRequest;
import com.backend.practice.model.dto.request.UserLoginRequest;
import com.backend.practice.model.dto.request.UserRegisterRequest;
import com.backend.practice.util.exception.UserAlreadyExistException;
import com.backend.practice.util.exception.UserNotFoundException;
import com.backend.practice.util.exception.WrongPasswordException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserService {
    UserDetailsService userDetailsService();

    @Transactional(rollbackFor = Exception.class)
    UserDto signUp(UserRegisterRequest request) throws UserAlreadyExistException;

    UserDto loginUser(UserLoginRequest request) throws TooManyAttemptsException, WrongPasswordException, UserNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteUser(UserDeleteAccountRequest request) throws UserNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    String changePassword(ChangePasswordRequest request) throws UserNotFoundException, WrongPasswordException;

    @Transactional(rollbackFor = Exception.class)
    UserDto updateUserInfo(Integer id, UserDto request) throws UserNotFoundException;

    UserDetails loadUserByUserName(String userEmail);
}
