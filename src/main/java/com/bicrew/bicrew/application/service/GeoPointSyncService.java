package com.bicrew.bicrew.application.service;

import com.bicrew.bicrew.application.external.GeoPointSyncPort;
import com.bicrew.bicrew.domain.model.GeoPoint;
import com.bicrew.bicrew.domain.model.UserGeoPoint;
import com.bicrew.bicrew.domain.usecase.GeoPointSyncUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GeoPointSyncService implements GeoPointSyncUseCase {

    private final GeoPointSyncPort geoPointSyncPort;

    @Override
    public UserGeoPoint syncAndGetUserGeoPoint(Long groupId, String nickname, GeoPoint geoPoint) {
        return geoPointSyncPort.syncAndGetGeoPoint(groupId, nickname, geoPoint);
    }
}
