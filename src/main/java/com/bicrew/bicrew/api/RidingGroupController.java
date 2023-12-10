package com.bicrew.bicrew.api;

import com.bicrew.bicrew.api.request.CreateGroupRequest;
import com.bicrew.bicrew.api.request.GroupJoinRequest;
import com.bicrew.bicrew.api.response.GroupJoinResponse;
import com.bicrew.bicrew.domain.usecase.RidingGroupUseCase;
import com.bicrew.bicrew.support.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groups")
public class RidingGroupController {

    private final RidingGroupUseCase ridingGroupUseCase;

    @PostMapping
    public ResponseEntity<Void> createGroup(@RequestBody CreateGroupRequest createGroupRequest) {
        ridingGroupUseCase.createGroup(createGroupRequest.groupName(), createGroupRequest.groupPassword());

        return ResponseEntity.ok().build();
    }

    @PostMapping("user-join")
    public ResponseEntity<GroupJoinResponse> groupJoin(@RequestBody GroupJoinRequest groupJoinRequest,
                                                       @Login String nickname) {

        final var groupId = ridingGroupUseCase
                .joinUserToGroup(nickname, groupJoinRequest.groupName(), groupJoinRequest.groupPassword());
        final var groupJoinResponse = new GroupJoinResponse(groupId);

        return ResponseEntity.ok(groupJoinResponse);
    }
}
