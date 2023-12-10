package com.bicrew.bicrew.api;

import com.bicrew.bicrew.api.request.GeoPointSyncRequest;
import com.bicrew.bicrew.api.response.GeoPointSyncResponse;
import com.bicrew.bicrew.domain.usecase.GeoPointSyncUseCase;
import com.bicrew.bicrew.support.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/locations")
public class GeoPointSyncController {

    private final GeoPointSyncUseCase geoPointSyncUseCase;

    @PostMapping
    public ResponseEntity<GeoPointSyncResponse> syncAndGetGeoPoint(@RequestBody GeoPointSyncRequest geoPointSyncRequest,
                                                   @Login String nickname) {
        final var userGeoPoint = geoPointSyncUseCase
                .syncAndGetUserGeoPoint(geoPointSyncRequest.groupId(), nickname, geoPointSyncRequest.coordinate());

        final var geoPointSyncResponse = GeoPointSyncResponse.from(userGeoPoint);
        return ResponseEntity.ok(geoPointSyncResponse);
    }
}
