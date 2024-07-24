package com.backend.practice.model.dto.request;

import lombok.Data;

/**
 * DTO for {@link com.backend.practice.model.entity.user.User}
*/
@Data
public class UserDeleteAccountRequest {
    private String email;
    private String password;
}
