package com.carlos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

import com.carlos.entity.Username;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JwtUtils {
    
    private static final String secretKey = "spring.jwt.sec";
    
    public static String generateToken(Username user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        Date now = new Date();
        Long hour = 1000L * 60L * 60L;
        return Jwts.builder().claim("userDetails", userJson)
            .setIssuer("com.carlos")
            .setSubject(user.getUsername())
            .setExpiration(new Date(now.getTime() + hour))
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
    }
    
    public static Username parseToken(String token) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Claims claims = Jwts.parser()
        		.setSigningKey(secretKey)
        		.parseClaimsJws(token)
        		.getBody();
        String credentialsJson = claims.get("userDetails", String.class);
        return mapper.readValue(credentialsJson, Username.class);
    }

}
