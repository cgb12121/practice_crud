package com.backend.practice.authentication;

import com.backend.practice.model.entity.user.User;
import com.backend.practice.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class UserFilter {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository.findByEmail(username);

            if (user == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }

            String userName = user.getUsername();
            String password = user.getPassword();

            boolean accountNonExpired = user.isAccountNonExpired();
            boolean credentialsNonExpired = user.isCredentialsNonExpired();
            boolean accountNonLocked = user.isAccountNonLocked();
            boolean enabled = user.isEnabled();

            if (!accountNonExpired) {
                throw new AccountExpiredException("Account Expired");
            }

            if (!credentialsNonExpired) {
                throw new CredentialsExpiredException("Credentials Expired");
            }

            if (!accountNonLocked) {
                throw new LockedException("Account is Locked");
            }

            if (!enabled) {
                throw new DisabledException("Account is Disabled");
            }

            List<SimpleGrantedAuthority> authorities = user
                    .getAuthorities()
                    .stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                    .collect(Collectors.toList());

            return org.springframework.security.core.userdetails.User
                    .withUsername(userName)
                    .password(password)
                    .authorities(authorities)
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        };
    }
}