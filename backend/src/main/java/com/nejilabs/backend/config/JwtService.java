package com.nejilabs.backend.config;

import java.security.Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  // ATTEMPT#1: Not able to run app
  // @Autowired
  // private static ConfigProperties configProperties;
  // private static final String SECRET_KEY =
  // configProperties.getConfigValue("jwt.service.secret-key");

  // ATTEMPT#2: Able to run app
  // @Autowired
  // private String getJwtServiceSecretKey;

  // ATTEMPT#3:
  @Autowired
  private static String getJwtServiceSecretKey;

  public String extractUsername(String token) {
    return null;
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(getJwtServiceSecretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}