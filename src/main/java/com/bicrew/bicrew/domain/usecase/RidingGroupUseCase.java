package com.bicrew.bicrew.domain.usecase;

public interface RidingGroupUseCase {

    void createGroup(String groupName, String groupPassword);

    Long joinUserToGroup(String nickname, String groupName, String groupPassword);
}
