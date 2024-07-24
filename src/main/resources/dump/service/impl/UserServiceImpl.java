//package com.backend.practice.util.dump.service.impl;
//
//import com.backend.practice.domain.kafka.KafkaProducer;
//import com.backend.practice.domain.kafka.Topic;
//import com.backend.practice.model.dto.UserDto;
//import com.backend.practice.model.dto.request.ChangePasswordRequest;
//import com.backend.practice.model.dto.request.UserDeleteAccountRequest;
//import com.backend.practice.model.dto.request.UserLoginRequest;
//import com.backend.practice.model.dto.request.UserRegisterRequest;
//import com.backend.practice.model.entity.user.User;
//import com.backend.practice.repository.user.UserRepository;
//import com.backend.practice.util.dump.service.UserService;
//import com.backend.practice.util.exception.TooManyAttemptsException;
//import com.backend.practice.util.exception.UserAlreadyExistException;
//import com.backend.practice.util.exception.UserNotFoundException;
//import com.backend.practice.util.exception.WrongPasswordException;
//import com.backend.practice.util.mapper.UserMapper;
//import com.backend.practice.util.security.IPasswords;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.Base64;
//
//import static com.backend.practice.model.entity.user.Role.USER;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//
//    private final IPasswords passwords;
//
//    private final UserMapper userMapper;
//
//    private final KafkaProducer kafkaProducer;
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public UserDto signUp(UserRegisterRequest request) throws UserAlreadyExistException {
//        if (userRepository.findByEmail(request.getEmail()) != null) {
//            throw new UserAlreadyExistException("Email already used: " + request.getEmail());
//        }
//
//        User user = new User();
//
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setAddress(request.getAddress());
//        user.setPhoneNumber(request.getPhoneNumber());
//        user.setEmail(request.getEmail());
//        user.setRole(USER);
//        user.setLoginAttempts(0);
//        user.setLastLogin(LocalDateTime.now());
//
//        // Generate salt and hash password
//        byte[] saltValue = passwords.getSalt64();
//        String encodeMethod = "SHA-256";
//        byte[] passwordHash = passwords.hash(request.getPassword(), saltValue);
//
//        user.setSalt(saltValue);
//        user.setPassword(Base64.getEncoder().encodeToString(passwordHash));
//        user.setEncodeMethod(encodeMethod);
//
////        User user = User.builder()
////                .firstName(request.getFirstName())
////                .lastName(request.getLastName())
////                .address(request.getAddress())
////                .phoneNumber(request.getPhoneNumber())
////                .email(request.getEmail())
////                .role(USER)
////                .loginAttempts(0)
////                .lastLogin(LocalDateTime.now())
////                .password(Base64.getEncoder().encodeToString(passwordHash))
////                .salt(saltValue)
////                .encodeMethod(encodeMethod)
////                .build();
//
//        user = userRepository.save(user);
//        kafkaProducer.sendMessage(Topic.USER_REGISTER_TOPIC, "User registered: " + user.getEmail());
//
//        return userMapper.toDto(user);
//    }
//
//    @Override
//    public UserDto loginUser(UserLoginRequest request) throws TooManyAttemptsException, WrongPasswordException, UserNotFoundException {
//        User user = userRepository.findByEmail(request.getEmail());
//
//        if (user == null) {
//            throw new UserNotFoundException("User not found " + request.getEmail());
//        }
//
//        int attempts = user.getLoginAttempts();
//        LocalDateTime lastLogin = user.getLastLogin();
//
//        if (lastLogin.plusMinutes(15).isAfter(LocalDateTime.now())) {
//            user.setLoginAttempts(0);
//            userRepository.save(user);
//        }
//
//        if (attempts > 5) {
//            throw new TooManyAttemptsException("Your banned!");
//        }
//
//        byte[] storedPasswordHash = Base64.getDecoder().decode(user.getPassword());
//
//        if (!passwords.isExpectedPassword(request.getPassword(), user.getSalt(), storedPasswordHash)) {
//            user.setLoginAttempts(attempts + 1);
//            user.setLastLogin(LocalDateTime.now());
//            userRepository.save(user);
//            throw new WrongPasswordException("Wrong password! Please try again!");
//        }
//
//        kafkaProducer.sendMessage(Topic.USER_LOGIN_TOPIC, "User logged in: " + user.getEmail());
//        user.setLoginAttempts(0);
//        user.setLastLogin(LocalDateTime.now());
//        userRepository.save(user);
//
//        return userMapper.toDto(user);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void deleteUser(UserDeleteAccountRequest request) throws UserNotFoundException {
//        String userEmail = request.getEmail();
//        User user = userRepository.findByEmail(userEmail);
//
//        if (user == null) {
//            throw new UserNotFoundException("Email " + request.getEmail() + " does not exist!");
//        }
//
//        kafkaProducer.sendMessage(Topic.USER_DELETE_TOPIC, "User deleted: " + user.getEmail());
//
//        userRepository.deleteByEmail(userEmail);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public String changePassword(ChangePasswordRequest request) throws UserNotFoundException, WrongPasswordException {
//        User user = userRepository.findByEmail(request.getEmail());
//
//        if (user == null) {
//            throw new UserNotFoundException("Email " + request.getEmail() + " does not exist!");
//        }
//
//        byte[] storedPasswordHash = Base64.getDecoder().decode(user.getPassword());
//
//        if (!passwords.isExpectedPassword(request.getPassword(), user.getSalt(), storedPasswordHash)) {
//            throw new WrongPasswordException("Wrong password! Please try again!");
//        }
//
//        byte[] newSalt = passwords.getSalt64();
//        byte[] newPasswordHash = passwords.hash(request.getPassword(), newSalt);
//
//        user.setSalt(newSalt);
//        user.setPassword(Base64.getEncoder().encodeToString(newPasswordHash));
//        user.setEncodeMethod("SHA-256");
//
//        userRepository.save(user);
//        kafkaProducer.sendMessage(Topic.USER_CHANGE_PASSWORD_TOPIC, "User password changed: " + user.getEmail());
//
//        return "Password changed successfully";
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public UserDto updateUserInfo(Integer id, UserDto request) throws UserNotFoundException {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("Something went wrong!"));
//
//        userMapper.updateEntityFromDto(request, user);
//        user = userRepository.save(user);
//
//        kafkaProducer.sendMessage(Topic.USER_UPDATE_INFO_TOPIC, "User updated: " + user.getEmail());
//
//        return userMapper.toDto(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUserName(String userEmail) {
//        User user = userRepository.findByEmail(userEmail);
//        if (user == null) {
//            throw new UserNotFoundException("User not found " + userEmail);
//        }
//        return user;
//    }
//}
