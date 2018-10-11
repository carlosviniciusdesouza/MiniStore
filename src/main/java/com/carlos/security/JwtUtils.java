package com.carlos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

import com.carlos.entity.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JwtUtils {
    
    private static final String secretKey = "spring.jwt.sec";
    
    public static String generateToken(User user) throws JsonProcessingException {
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
    
    public static User parseToken(String token) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Claims claims = Jwts.parser()
        		.setSigningKey(secretKey)
        		.parseClaimsJws(token)
        		.getBody();
        String credentialsJson = claims.get("userDetails", String.class);
        System.out.println("LOSER " + credentialsJson);
        return mapper.readValue(credentialsJson, User.class);
    }

}
