package com.bicrew.bicrew.domain.model;

public record GeoPoint(
        Double lat,
        Double lon
) {

    public static GeoPoint empty() {
        return new GeoPoint(0.0, 0.0);
    }
}
