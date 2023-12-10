package com.bicrew.bicrew.application.service;

import com.bicrew.bicrew.application.external.JoinUserPort;
import com.bicrew.bicrew.application.external.RidingGroupPort;
import com.bicrew.bicrew.domain.usecase.RidingGroupUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RidingGroupService implements RidingGroupUseCase {

    private final RidingGroupPort ridingGroupPort;
    private final JoinUserPort joinUserPort;

    @Override
    public void createGroup(String groupName, String groupPassword) {
        if (ridingGroupPort.isNotUniqueGroupName(groupName)) {
            throw new IllegalArgumentException();
        }

        ridingGroupPort.createGroup(groupName, groupPassword);
    }

    @Override
    public Long joinUserToGroup(String nickname, String groupName, String groupPassword) {
        final Long groupId = ridingGroupPort.findGroupId(groupName, groupPassword);
        final Long userId = joinUserPort.findUserIdByNickname(nickname);

        ridingGroupPort.saveRidingGroupUser(userId, groupId);

        return groupId;
    }
}
