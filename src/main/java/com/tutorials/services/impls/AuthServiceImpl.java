package com.tutorials.services.impls;

import com.tutorials.models.UserModel;
import com.tutorials.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Value("${application.jwt.secret}")
    private String jwtSecret;

    @Value("${application.jwt.subject}")
    private String jwtSubject;

    public String getAccessToken(String userId) {
        return Optional.ofNullable(userRepository.findByUserId(userId)).map(userEntity -> {
            LocalDateTime currentTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
            Date issueDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());
            Date expiryDate = Date.from(currentTime.plusHours(1).atZone(ZoneId.systemDefault()).toInstant());
            String token = Jwts.builder()
                    .setSubject(jwtSubject)
                    .claim("id", userEntity.getId())
                    .claim("userId", userEntity.getUserId())
                    .claim("userName", userEntity.getUserName())
                    .claim("userRole", userEntity.getUserRole())
                    .setIssuedAt(issueDate)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS256, jwtSecret)
                    .compact();
            return token;
        }).orElse("User not found");
    }

    public UserModel validateToken(String jwtToken) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody();
        return Optional.ofNullable(Optional.ofNullable((String) claims.get("userId")).orElse(null))
                .map(userId -> userRepository.findByUserId(userId))
                .filter(userEntity -> Optional.ofNullable(userEntity).isPresent())
                .map(userEntity -> {
                    UserModel userModel = new UserModel();
                    userModel.setId(userEntity.getId());
                    userModel.setUserId(userEntity.getUserId());
                    userModel.setUserName(userEntity.getUserName());
                    userModel.setUserRole(userEntity.getUserRole());
                    userModel.setUserEmail(userEntity.getUserEmail());
                    userModel.setUserContact(userEntity.getUserContact());
                    return userModel;
                }).orElse(null);
    }
}
