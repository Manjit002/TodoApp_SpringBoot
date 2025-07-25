package com.mjt.todoapplication.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtHelper {

    public static final long TOKEN_VALIDITY = 5*60*60*1000;

    public static final String SECRET_KEY = "hfytftyftyftyfytfgytftrftfftftctygfvchgftyfytftyfgytgyghfgygftyfgtyfghfgyftyftyf";

    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);

    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
       final Claims claims= getAllClaimsFromToken(token);
       return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build().parseSignedClaims(token).getPayload();
    }

    public Boolean isTokenExpired(String token){
        final Date expiration= getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public String generateToken(UserDetails userDetails){
        HashMap<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }


}

