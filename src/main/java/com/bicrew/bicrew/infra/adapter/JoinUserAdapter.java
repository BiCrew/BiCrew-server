package com.bicrew.bicrew.infra.adapter;

import com.bicrew.bicrew.application.external.JoinUserPort;
import com.bicrew.bicrew.domain.model.JoinUser;
import com.bicrew.bicrew.infra.db.JoinUserRepository;
import com.bicrew.bicrew.infra.db.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinUserAdapter implements JoinUserPort {

    private final JoinUserRepository joinUserRepository;

    @Override
    public boolean isNotUniqueNickname(String nickname) {
        return joinUserRepository.existsByNickname(nickname);
    }

    @Override
    public void saveJoinUser(JoinUser joinUser) {
        joinUserRepository.save(new UserEntity(null, joinUser.nickname(), joinUser.encryptedPassword()));
    }
}
