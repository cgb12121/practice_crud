package com.backend.practice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

public class Topic {
    public static final String USER_LOGIN_TOPIC = "user_login";
    public static final String USER_REGISTER_TOPIC = "user_register";
    public static final String USER_DELETE_TOPIC = "user_delete";
    public static final String USER_CHANGE_PASSWORD_TOPIC = "user_change_password";
    public static final String USER_UPDATE_INFO_TOPIC = "user_update_info";

    public NewTopic UserLoginTopic() {
        return TopicBuilder.name(USER_LOGIN_TOPIC).partitions(10).build();
    };

    public NewTopic UserRegisterTopic() {
        return TopicBuilder.name(USER_REGISTER_TOPIC).partitions(10).build();
    }

    public NewTopic UserDeleteTopic() {
        return TopicBuilder.name(USER_DELETE_TOPIC).partitions(10).build();
    }

    public NewTopic UserChangePasswordTopic() {
        return TopicBuilder.name(USER_CHANGE_PASSWORD_TOPIC).partitions(10).build();
    }

    public NewTopic UserUpdateInfoTopic() {
        return TopicBuilder.name(USER_UPDATE_INFO_TOPIC).partitions(10).build();
    }
}
