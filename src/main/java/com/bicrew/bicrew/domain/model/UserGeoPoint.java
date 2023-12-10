package com.bicrew.bicrew.domain.model;

import java.util.HashMap;
import java.util.Map;

public record UserGeoPoint(
        Map<String, GeoPoint> geoPointByNickname
) {
    public static UserGeoPoint empty() {
        return new UserGeoPoint(new HashMap<>());
    }
}
