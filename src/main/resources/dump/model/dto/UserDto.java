//package com.backend.practice.dump.model.dto;
//
//import com.backend.practice.dump.model.entity.user.Role;
//import com.backend.practice.dump.model.entity.user.User;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Value;
//
//import java.io.Serializable;
//
///**
// * DTO for {@link User}
// */
//@Value
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class UserDto implements Serializable {
//
//    @JsonIgnore
//    String firstName;
//
//    @JsonIgnore
//    String lastName;
//
//    @JsonIgnore
//    String address;
//
//    @JsonIgnore
//    String phoneNumber;
//
//    String email;
//
//    String password;
//
//    @JsonIgnore
//    byte[] salt;
//
//    @JsonIgnore
//    String encodeMethod;
//
//    @JsonIgnore
//    Role role;
//}
