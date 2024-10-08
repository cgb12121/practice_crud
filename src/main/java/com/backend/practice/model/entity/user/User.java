package com.backend.practice.model.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class User implements UserDetails {
    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "First name can not be empty!")
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @NotNull(message = "Second name can not be empty!")
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @NotNull(message = "Invalid address!")
    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Pattern(regexp = "^\\d{20}$", message = "Invalid phone number!")
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Email(message = "Invalid email!")
    @Column(name = "email", updatable = false, nullable = false)
    private String email;

    @NotNull(message = "Your password can not be empty!")
    @Size(min = 8, max = 64, message = "Your password can not be too long or too short.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}\\[\\]:\"?><~])(?=.*[0-9])(?=.*[a-z]).{8,}$",
            message = "Password must be at least 8 characters long, contain at least 1 uppercase letter, 1 special character, 1 number, and 1 lowercase letter."
    )
    @Column(name = "password", nullable = false, length = 500)
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Your role can not be empty!")
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "login_attempts", columnDefinition = "0")
    private int loginAttempts;

    @Timestamp
    @Column(name = "last_login", columnDefinition = "null")
    private LocalDateTime lastLogin;

    @Timestamp
    @Column(name = "last_updated", columnDefinition = "null")
    private LocalDateTime lastUpdated;

    @Column(name = "is_account_non_expired", columnDefinition = "1")
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked", columnDefinition = "1")
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired", columnDefinition = "1")
    private boolean isCredentialsNonExpired;

    @Column(name = "is_enabled", columnDefinition = "1")
    private boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}