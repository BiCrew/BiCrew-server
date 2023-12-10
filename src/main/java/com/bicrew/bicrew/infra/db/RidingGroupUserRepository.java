package com.bicrew.bicrew.infra.db;

import com.bicrew.bicrew.infra.db.entity.RidingGroupUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RidingGroupUserRepository extends JpaRepository<RidingGroupUserEntity, Long> {
}
