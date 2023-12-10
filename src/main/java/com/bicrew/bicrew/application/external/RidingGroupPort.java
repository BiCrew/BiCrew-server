package com.bicrew.bicrew.application.external;

public interface RidingGroupPort {

    boolean isNotUniqueGroupName(String groupName);

    void createGroup(String groupName, String groupPassword);

    void saveRidingGroupUser(Long userId, Long groupId);

    Long findGroupId(String groupName, String groupPassword);

}
