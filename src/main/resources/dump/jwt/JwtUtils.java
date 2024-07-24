//package com.backend.practice.domain.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.Map;
//import java.util.function.Function;
//
//@Component
//public class JwtUtils {
//
//    private final SecretKey key;
//    private static final long EXPIRATION_TIME = 3600000; // 1h
//
//    public JwtUtil() {
//        String secret = "HELLO_WORLD_GIMME_BEER_HELLO_WORLD_GIMME_BEER";
//        byte[] keyBytes = secret.getBytes();
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
//
//        return Jwts.builder()
//                .subject(userDetails.getUsername())
//                .issuedAt(now)
//                .expiration(expiryDate)
//                .signWith(key)
//                .compact();
//    }
//
//    public String generateRefreshToken(Map<String, Object> claims, UserDetails userDetails) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
//
//        return Jwts.builder()
//                .claims(claims)
//                .subject(userDetails.getUsername())
//                .issuedAt(now)
//                .expiration(expiryDate)
//                .signWith(key)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .verifyWith(key)
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//}
