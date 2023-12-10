package com.bicrew.bicrew.api.request;

public record CreateGroupRequest(
        String groupName,
        String groupPassword
) {
}
