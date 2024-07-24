package com.backend.practice.model.dto.request;

import lombok.Data;

/**
 * DTO for {@link com.backend.practice.model.entity.user.User}
 */
@Data
public class ChangePasswordRequest {
    private String email;
    private String phoneNumber;
    private String oldPassword;
    private String newPassword;
}
