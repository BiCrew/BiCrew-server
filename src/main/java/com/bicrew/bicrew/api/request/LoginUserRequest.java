package com.bicrew.bicrew.api.request;

public record LoginUserRequest(
        String nickname,
        String password
){
}
