package com.bicrew.bicrew.infra.db;

import com.bicrew.bicrew.infra.db.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinUserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByNickname(String nickname);

    Optional<UserEntity> findByNickname(String nickname);
}
