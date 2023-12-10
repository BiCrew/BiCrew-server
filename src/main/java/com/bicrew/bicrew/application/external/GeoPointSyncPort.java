package com.bicrew.bicrew.application.external;

import com.bicrew.bicrew.domain.model.GeoPoint;
import com.bicrew.bicrew.domain.model.UserGeoPoint;

public interface GeoPointSyncPort {

    UserGeoPoint syncAndGetGeoPoint(Long groupId, String nickname, GeoPoint geoPoint);
}
