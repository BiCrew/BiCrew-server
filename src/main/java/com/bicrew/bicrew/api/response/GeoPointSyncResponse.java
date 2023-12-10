package com.bicrew.bicrew.api.response;

import com.bicrew.bicrew.domain.model.GeoPoint;
import com.bicrew.bicrew.domain.model.UserGeoPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public record GeoPointSyncResponse(
        List<LocationResponse> locations
){
    public record LocationResponse(
            String nickname,
            GeoPoint coordinate
    ) {
    }

    public static GeoPointSyncResponse from(UserGeoPoint userGeoPoint) {
        final List<LocationResponse> locations = new ArrayList<>();

        final Map<String, GeoPoint> geoPointByNickname = userGeoPoint.geoPointByNickname();
        for (Entry<String, GeoPoint> geoPointEntry : geoPointByNickname.entrySet()) {
            locations.add(new LocationResponse(geoPointEntry.getKey(), geoPointEntry.getValue()));
        }

        return new GeoPointSyncResponse(locations);
    }
}
