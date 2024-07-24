package com.backend.practice.model.entity.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER(Set.of(Permissions.CREATE, Permissions.UPDATE)),
    STAFF(Set.of(Permissions.CREATE, Permissions.UPDATE, Permissions.READ)),
    ADMIN(Set.of(Permissions.CREATE, Permissions.UPDATE, Permissions.DELETE, Permissions.READ));

    private final Set<Permissions> permissions;

    public String getRole() {
        return this.name();
    }

}
