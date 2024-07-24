package com.backend.practice.service;

import com.backend.practice.model.dto.UserDto;
import com.backend.practice.model.dto.request.UserRegisterRequest;
import com.backend.practice.util.exception.UserAlreadyExistException;
import org.springframework.transaction.annotation.Transactional;

public interface AdminService {
    @Transactional(rollbackFor = Exception.class)
    UserDto createStaff(UserRegisterRequest request) throws UserAlreadyExistException;
}
