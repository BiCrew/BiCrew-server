package com.bicrew.bicrew.api.request;

public record JoinUserRequest(
        String nickname,
        String password
){
}
