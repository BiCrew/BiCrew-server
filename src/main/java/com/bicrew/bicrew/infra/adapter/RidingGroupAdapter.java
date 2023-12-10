package com.bicrew.bicrew.infra.adapter;

import com.bicrew.bicrew.application.external.RidingGroupPort;
import com.bicrew.bicrew.infra.db.JoinUserRepository;
import com.bicrew.bicrew.infra.db.RidingGroupRepository;
import com.bicrew.bicrew.infra.db.RidingGroupUserRepository;
import com.bicrew.bicrew.infra.db.entity.RidingGroupEntity;
import com.bicrew.bicrew.infra.db.entity.RidingGroupUserEntity;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RidingGroupAdapter implements RidingGroupPort {

    private final RidingGroupRepository ridingGroupRepository;
    private final JoinUserRepository joinUserRepository;
    private final RidingGroupUserRepository ridingGroupUserRepository;

    @Override
    public boolean isNotUniqueGroupName(String groupName) {
        return ridingGroupRepository.existsByGroupName(groupName);
    }

    @Override
    public void createGroup(String groupName, String groupPassword) {
        final RidingGroupEntity ridingGroupEntity = new RidingGroupEntity(null, groupName, groupPassword,
                new ArrayList<>());

        ridingGroupRepository.save(ridingGroupEntity);
    }

    @Override
    public void saveRidingGroupUser(Long userId, Long groupId) {
        final var userEntity = joinUserRepository.findById(userId).orElseThrow();
        final var ridingGroupEntity = ridingGroupRepository.findById(groupId).orElseThrow();

        final var ridingGroupUserEntity = new RidingGroupUserEntity(null, userEntity,
                ridingGroupEntity);

        ridingGroupUserRepository.save(ridingGroupUserEntity);
    }

    @Override
    public Long findGroupId(String groupName, String groupPassword) {
        final var ridingGroupEntity = ridingGroupRepository
                .findIdByGroupNameAndGroupPassword(groupName, groupPassword).orElseThrow();
        return ridingGroupEntity.getId();
    }
}
