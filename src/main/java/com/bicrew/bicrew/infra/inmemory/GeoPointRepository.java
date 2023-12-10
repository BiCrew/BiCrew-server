package com.bicrew.bicrew.infra.inmemory;

import com.bicrew.bicrew.domain.model.GeoPoint;
import com.bicrew.bicrew.domain.model.UserGeoPoint;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class GeoPointRepository {

    private static final Map<Long, UserGeoPoint> usersGeoPointByGroupId = new HashMap<>();

    public UserGeoPoint syncAndGetGeoPoint(Long groupId, String nickname, GeoPoint geoPoint) {
        if (!usersGeoPointByGroupId.containsKey(groupId)) {
            usersGeoPointByGroupId.put(groupId, UserGeoPoint.empty());
        }

        var userGeoPoint = usersGeoPointByGroupId.get(groupId);

        userGeoPoint.geoPointByNickname().put(nickname, geoPoint);
        usersGeoPointByGroupId.put(groupId, userGeoPoint);

        return userGeoPoint;
    }
}
