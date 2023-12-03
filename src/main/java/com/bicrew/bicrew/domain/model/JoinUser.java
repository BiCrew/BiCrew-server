package com.bicrew.bicrew.domain.model;

public record JoinUser(
        String nickname,
        String encryptedPassword
) {
}
