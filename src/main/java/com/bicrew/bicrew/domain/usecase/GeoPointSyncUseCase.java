package com.bicrew.bicrew.domain.usecase;

import com.bicrew.bicrew.domain.model.GeoPoint;
import com.bicrew.bicrew.domain.model.UserGeoPoint;

public interface GeoPointSyncUseCase {

    UserGeoPoint syncAndGetUserGeoPoint(Long groupId, String nickname, GeoPoint geoPoint);

}
