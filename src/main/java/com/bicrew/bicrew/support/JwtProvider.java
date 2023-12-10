package com.bicrew.bicrew.support;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expired.access}")
    private long expiredTime;

    private Key signKey;

    @PostConstruct
    public void init(){
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        signKey = Keys.hmacShaKeyFor(keyBytes);
    }


    public String createAccessToken(String nickname) {
        final var now = new Date();
        final var expiredAt = new Date(now.getTime() + expiredTime);

        return Jwts.builder()
                .claim("nickname", nickname)
                .setIssuedAt(now)
                .setExpiration(expiredAt)
                .signWith(signKey)
                .compact();
    }

    public String getPayload(String token) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("nickname", String.class);
    }
}
