package com.bicrew.bicrew.api;

import com.bicrew.bicrew.api.request.JoinUserRequest;
import com.bicrew.bicrew.domain.usecase.JoinUseCase;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public ResponseEntity<Void> joinUser(@RequestBody JoinUserRequest joinUserRequest) {
        joinUseCase.userJoin(joinUserRequest.nickname(), joinUserRequest.password());

        return ResponseEntity.ok().build();
    }
}
