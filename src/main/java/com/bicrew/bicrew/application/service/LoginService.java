package com.bicrew.bicrew.application.service;

import com.bicrew.bicrew.application.external.JoinUserPort;
import com.bicrew.bicrew.domain.usecase.LoginUseCase;
import com.bicrew.bicrew.support.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements LoginUseCase {

    private final JoinUserPort joinUserPort;
    private final JwtProvider jwtProvider;

    @Override
    public String login(String nickname, String encryptedPassword) {
        final var joinUser = joinUserPort.findByNickname(nickname);

        if (joinUser.isIncorrectPassword(encryptedPassword)) {
            throw new IllegalArgumentException();
        }

        return jwtProvider.createAccessToken(nickname);
    }
}
