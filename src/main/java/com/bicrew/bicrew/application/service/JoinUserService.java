package com.bicrew.bicrew.application.service;

import com.bicrew.bicrew.application.external.JoinUserPort;
import com.bicrew.bicrew.domain.model.JoinUser;
import com.bicrew.bicrew.domain.usecase.JoinUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JoinUserService implements JoinUseCase {

    private final JoinUserPort joinUserPort;

    @Override
    public void userJoin(String nickname, String password) {
        if (joinUserPort.isNotUniqueNickname(nickname)) {
            throw new IllegalArgumentException();
        }

        final JoinUser joinUser = new JoinUser(nickname, password);

        joinUserPort.saveJoinUser(joinUser);
    }
}
