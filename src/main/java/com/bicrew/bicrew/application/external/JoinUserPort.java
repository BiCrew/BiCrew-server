package com.bicrew.bicrew.application.external;

import com.bicrew.bicrew.domain.model.JoinUser;

public interface JoinUserPort {

    boolean isNotUniqueNickname(String nickname);

    void saveJoinUser(JoinUser joinUser);

    JoinUser findByNickname(String nickname);
}
