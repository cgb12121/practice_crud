//package com.backend.practice.util.dump.service.impl;
//
//import com.backend.practice.util.dump.service.JwtService;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.impl.lang.Function;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.Map;
//
//@Service
//public class JwtServiceImpl implements JwtService {
//
//    private static final String SECRET_KEY = "my key is here!";
//
//    @Override
//    public String generateToken(UserDetails userDetails) {
//        return Jwts.builder()
//                .subject(userDetails.getUsername())
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
//                .signWith(getSigninKey())
//                .compact();
//    }
//
//    @Override
//    public String generateRefreshToken(Map<String, Object> claims, UserDetails userDetails) {
//
//    }
//
//    @SuppressWarnings("SpellCheckingInspection")
//    private SecretKey getSigninKey() {
//       byte[] key = Decoders.BASE64.decode(SECRET_KEY);
//       return Keys.hmacShaKeyFor(key);
//    }
//
//    @Override
//    public <T> T extractClaims(String token, Function<Claims, T> claimsResolvers) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolvers.apply(claims);
//    }
//
//    @Override
//    public Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .verifyWith(getSigninKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    @Override
//    public String extractUserName(String token) {
//        return extractClaims(token, Claims::getSubject);
//    }
//
//    @Override
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUserName(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    @Override
//    public boolean isTokenExpired(String token) {
//        final Date expiration = extractClaims(token, Claims::getExpiration);
//        return expiration.before(new Date());
//    }
//
//}
