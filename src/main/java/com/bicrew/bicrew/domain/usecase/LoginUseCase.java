package com.bicrew.bicrew.domain.usecase;

public interface LoginUseCase {

    String login(String nickname, String encryptedPassword);

}
