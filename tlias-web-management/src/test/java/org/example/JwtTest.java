package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGenerateJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "admin");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "aXRoZWltYQ==")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 1000))
                .compact();

        System.out.println(jwt);
    }

    @Test
    public void parseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc4ODM1ODM0M30.m6XsZnNfcBnylqpLu7o2lS3dRdNU0dDS9nIGyT0igyQ";
        Claims claims = Jwts.parser()
                .setSigningKey("aXRoZWltYQ==")//指定签名密钥
                .parseClaimsJws(token)
                .getBody();

        System.out.println(claims);
    }
}
