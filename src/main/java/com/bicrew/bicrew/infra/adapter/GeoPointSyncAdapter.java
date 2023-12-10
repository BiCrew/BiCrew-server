package com.bicrew.bicrew.infra.adapter;

import com.bicrew.bicrew.application.external.GeoPointSyncPort;
import com.bicrew.bicrew.domain.model.GeoPoint;
import com.bicrew.bicrew.domain.model.UserGeoPoint;
import com.bicrew.bicrew.infra.inmemory.GeoPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GeoPointSyncAdapter implements GeoPointSyncPort {

    private final GeoPointRepository geoPointRepository;

    @Override
    public UserGeoPoint syncAndGetGeoPoint(Long groupId, String nickname, GeoPoint geoPoint) {
        return geoPointRepository.syncAndGetGeoPoint(groupId, nickname, geoPoint);
    }
}
