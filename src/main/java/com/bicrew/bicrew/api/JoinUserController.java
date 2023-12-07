package com.bicrew.bicrew.api;

import com.bicrew.bicrew.api.request.JoinUserRequest;
import com.bicrew.bicrew.api.request.LoginUserRequest;
import com.bicrew.bicrew.domain.usecase.JoinUseCase;
import com.bicrew.bicrew.domain.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class JoinUserController {

    private final JoinUseCase joinUseCase;
    private final LoginUseCase loginUseCase;

    @PostMapping
    public ResponseEntity<Void> joinUser(@RequestBody JoinUserRequest joinUserRequest) {
        joinUseCase.userJoin(joinUserRequest.nickname(), joinUserRequest.password());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        final var accessToken = loginUseCase.login(loginUserRequest.nickname(), loginUserRequest.password());

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .build();
    }
}
