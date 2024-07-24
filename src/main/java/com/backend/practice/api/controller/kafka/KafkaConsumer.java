package com.backend.practice.api.controller.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = Topic.USER_LOGIN_TOPIC, groupId = "user_group_id")
    public void consumeLogin(String message) {
        log.info("#### -> Consumed message from user_login -> {}", message);
        processMessage(message);
    }

    @KafkaListener(topics = Topic.USER_REGISTER_TOPIC, groupId = "user_group_id")
    public void consumeRegister(String message) {
        log.info("#### -> Consumed message from user_register -> {}", message);
        processMessage(message);
    }

    @KafkaListener(topics = Topic.USER_DELETE_TOPIC, groupId = "user_group_id")
    public void consumeDelete(String message) {
        log.info("#### -> Consumed message from user_delete -> {}", message);
        processMessage(message);
    }

    @KafkaListener(topics = Topic.USER_CHANGE_PASSWORD_TOPIC, groupId = "user_group_id")
    public void consumeChangePassword(String message) {
        log.info("#### -> Consumed message from user_change_password -> {}", message);
        processMessage(message);
    }

    @KafkaListener(topics = Topic.USER_UPDATE_INFO_TOPIC, groupId = "user_group_id")
    public void consumeUpdate(String message) {
        log.info("#### -> Consumed message from user_update_info -> {}", message);
        processMessage(message);
    }

    private void processMessage(String message) {
        if (message.contains("User registered")) {
            handleUserRegistration(message);
        } else if (message.contains("User logged in")) {
            handleUserLogin(message);
        } else if (message.contains("User deleted")) {
            handleUserDeletion(message);
        } else if (message.contains("User password changed")) {
            handleChangePassword(message);
        } else if (message.contains("User updated")) {
            handleUserUpdate(message);
        }
    }

    private void handleUserRegistration(String message) {
        log.info("Handling user registration: {}", message);
        String email = extractEmailFromMessage(message);
        updateUserAnalytics(email);
        sendWelcomeEmail(email);
    }

    private String extractEmailFromMessage(String message) {
        return message.split(":")[1].trim();
    }

    private void updateUserAnalytics(String email) {
        log.info("Updating analytics for user: {}", email);
    }

    private void sendWelcomeEmail(String email) {
        log.info("Sending welcome email to: {}", email);
    }

    private void handleUserLogin(String message) {
        log.info("Handling user login: {}", message);
        String email = extractEmailFromMessage(message);
        updateLastLoginTime(email);
        updateUserActivityMetrics(email);
    }

    private void updateLastLoginTime(String email) {
        log.info("Updating last login time for: {}", email);
    }

    private void updateUserActivityMetrics(String email) {
        log.info("Updating activity metrics for: {}", email);
    }

    private void handleUserDeletion(String message) {
        log.info("Handling user deletion: {}", message);
        String email = extractEmailFromMessage(message);
        cleanUpUserData(email);
        notifySystemsOfUserDeletion(email);
    }

    private void cleanUpUserData(String email) {
        log.info("Cleaning up data for: {}", email);
    }

    private void notifySystemsOfUserDeletion(String email) {
        log.info("Notifying other systems about deletion of: {}", email);
    }

    private void handleChangePassword(String message) {
        log.info("Handling password change: {}", message);
        String email = extractEmailFromMessage(message);
        notifyUserPasswordChange(email);
        updateSecurityMetrics(email);
    }

    private void notifyUserPasswordChange(String email) {
        log.info("Notifying user about password change: {}", email);
    }

    private void updateSecurityMetrics(String email) {
        log.info("Updating security metrics for: {}", email);
    }

    private void handleUserUpdate(String message) {
        log.info("Handling user update: {}", message);
        String email = extractEmailFromMessage(message);
        synchronizeUserInfo(email);
        updateUserProfileCache(email);
    }

    private void synchronizeUserInfo(String email) {
        log.info("Synchronizing user info for: {}", email);
    }

    private void updateUserProfileCache(String email) {
        log.info("Updating profile cache for: {}", email);
    }
}
