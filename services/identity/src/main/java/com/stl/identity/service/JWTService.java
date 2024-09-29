package com.stl.identity.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.stl.identity.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiaryinseconds}")
    private int expiaryinseconds;
    private Algorithm algorithm;

    private static final String USERNAME_KEY ="USERID";

    @PostConstruct
    public void postConstruct() throws UnsupportedEncodingException {
        this.algorithm= Algorithm.HMAC256(algorithmKey);
    }


    public String generateJWT(User user){
        return JWT.create()
                .withClaim(USERNAME_KEY,user.getId())
                .withIssuer(issuer)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*expiaryinseconds))
                .sign(algorithm);
    }

    public Long getUserId(String token){
        return JWT.decode(token).getClaim(USERNAME_KEY).asLong();
    }




}
