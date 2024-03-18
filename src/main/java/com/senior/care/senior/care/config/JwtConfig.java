package com.senior.care.senior.care.config;


import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JwtConfig {
    private final String jwtSecret;
    private final long jwtExpiration;

    public JwtConfig() {
        Dotenv dotenv = Dotenv.load();
        jwtSecret = dotenv.get("JWT_SECRET");
        jwtExpiration = Long.parseLong(dotenv.get("JWT_EXPIRATION"));
    }
}
