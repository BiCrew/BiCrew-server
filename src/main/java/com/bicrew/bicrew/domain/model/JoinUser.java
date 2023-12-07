package com.bicrew.bicrew.domain.model;

public record JoinUser(
        String nickname,
        String encryptedPassword
) {

    public boolean isIncorrectPassword(String password) {
        return !encryptedPassword.equals(password);
    }
}
