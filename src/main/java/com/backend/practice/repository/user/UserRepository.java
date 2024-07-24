package com.backend.practice.repository.user;

import com.backend.practice.model.entity.user.Role;
import com.backend.practice.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    void deleteByEmail(String email);
    User findByRole(Role role);
}