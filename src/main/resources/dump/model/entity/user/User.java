//package com.backend.practice.dump.model.entity.user;
//
//import jakarta.persistence.*;
//import jdk.jfr.Timestamp;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.time.LocalDateTime;
//import java.util.Collection;
//import java.util.List;
//
//@Getter
//@Setter
//@Builder
//@Entity
//@Table(name = "user")
//@NoArgsConstructor
//@AllArgsConstructor
//public class User implements UserDetails {
//    @Id
//    @Column(name = "user_id", updatable = false, nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @Column(name = "first_name", nullable = false, length = 50)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false, length = 50)
//    private String lastName;
//
//    @Column(name = "address")
//    private String address;
//
//    @Column(name = "phone_number", length = 20)
//    private String phoneNumber;
//
//    @Column(name = "email", updatable = false, nullable = false)
//    private String email;
//
//    @Column(name = "password", nullable = false, length = 500)
//    private String password;
//
//    @Column(name = "salt", updatable = false, nullable = false)
//    private byte[] salt;
//
//    @Column(name = "encode_method", updatable = false, nullable = false)
//    private String encodeMethod;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "role", nullable = false)
//    private Role role;
//
//    @Column(name = "login_attempts")
//    private int loginAttempts;
//
//    @Timestamp
//    @Column(name = "last_login")
//    private LocalDateTime lastLogin;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(role.name()));
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}