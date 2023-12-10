package com.bicrew.bicrew.infra.db;

import com.bicrew.bicrew.infra.db.entity.RidingGroupEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RidingGroupRepository extends JpaRepository<RidingGroupEntity, Long> {

    boolean existsByGroupName(String groupName);

    Optional<RidingGroupEntity> findIdByGroupNameAndGroupPassword(String groupName, String groupPassword);
}
