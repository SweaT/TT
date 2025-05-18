package com.example.TT.persistent.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum UserRole implements GrantedAuthority {

    ADMIN("ADMIN"),
    USER("USER"),
    TRAINER("TRAINER"),
    MANAGER("MANAGER"),
    PLAYER("PLAYER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }

}
