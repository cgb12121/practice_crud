package com.backend.practice.model.dto;

import com.backend.practice.model.entity.user.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.backend.practice.model.entity.user.User}
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {

    @JsonIgnore
    String firstName;

    @JsonIgnore
    String lastName;

    @JsonIgnore
    String address;

    @JsonIgnore
    String phoneNumber;

    String email;

    String password;

    @JsonIgnore
    Role role;
}
