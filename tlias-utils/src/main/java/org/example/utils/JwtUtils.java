package org.example.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET_KEY = "aXRoZWltYQ";
    private static final long EXPIRATION_TIME = 12 * 60 *60 *1000;

    /**
     * 生成JWT令牌
     * @return
     */
    public static String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param  token
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

