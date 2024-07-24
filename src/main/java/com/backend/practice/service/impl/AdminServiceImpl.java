package com.backend.practice.service.impl;

import com.backend.practice.api.controller.kafka.KafkaProducer;
import com.backend.practice.api.controller.kafka.Topic;
import com.backend.practice.service.AdminService;
import com.backend.practice.model.dto.UserDto;
import com.backend.practice.model.dto.request.UserRegisterRequest;
import com.backend.practice.model.entity.user.User;
import com.backend.practice.repository.user.UserRepository;
import com.backend.practice.util.exception.UserAlreadyExistException;
import com.backend.practice.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.backend.practice.model.entity.user.Role.STAFF;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final KafkaProducer kafkaProducer;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDto createStaff(UserRegisterRequest request) throws UserAlreadyExistException {
        if (userRepository.findByEmail(request.getEmail()) != null) {
            throw new UserAlreadyExistException("Email already used: " + request.getEmail());
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setRole(STAFF);
        user.setLoginAttempts(0);
        user.setLastLogin(LocalDateTime.now());

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(encodedPassword);

        user = userRepository.save(user);
        kafkaProducer.sendMessage(Topic.USER_REGISTER_TOPIC, "User registered: " + user.getEmail());

        return userMapper.toDto(user);
    }

}
