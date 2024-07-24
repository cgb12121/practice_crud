package com.backend.practice.model.dto.request;

import lombok.Data;

/**
 * DTO for {@link com.backend.practice.model.entity.user.User}
 */
@Data
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
}
