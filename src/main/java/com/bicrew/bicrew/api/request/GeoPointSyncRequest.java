package com.bicrew.bicrew.api.request;

import com.bicrew.bicrew.domain.model.GeoPoint;

public record GeoPointSyncRequest(
        Long groupId,
        GeoPoint coordinate
) {
}
