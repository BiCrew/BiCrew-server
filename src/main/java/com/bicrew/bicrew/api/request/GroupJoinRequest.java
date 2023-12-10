package com.bicrew.bicrew.api.request;

public record GroupJoinRequest(
        String groupName,
        String groupPassword
) {
}
