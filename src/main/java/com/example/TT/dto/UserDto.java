package com.example.TT.dto;

import com.example.TT.persistent.model.UserRole;

import javax.annotation.Nullable;

public record UserDto(String login,
                      String password,
                      @Nullable String name,
                      String email,
                      @Nullable UserRole role) {
    @Override
    public String login() {
        return login;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    @Nullable
    public String name() {
        return name;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    @Nullable
    public UserRole role() {
        return role;
    }
}
