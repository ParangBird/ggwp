package com.backend.ggwp.domain.bbs.user.user;

public enum Role {
    ROLE_NORMAL_USER("NORMAL_USER"), ROLE_AUTHED_USER("AUTHE_USER"), ROLE_OAUTH2_USER("OAUTH2_USER");
    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
