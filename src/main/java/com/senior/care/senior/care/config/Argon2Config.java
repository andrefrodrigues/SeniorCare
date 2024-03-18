package com.senior.care.senior.care.config;


import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Argon2Config {
    private final int saltLength;
    private final int hashLength;
    private final int parallelism;
    private final int memory;
    private final int iterations;

    public Argon2Config() {
        Dotenv dotenv = Dotenv.load();
        saltLength = Integer.parseInt(dotenv.get("ARGON_SALT_LENGTH"));
        hashLength = Integer.parseInt(dotenv.get("ARGON_HASH_LENGTH"));
        parallelism = Integer.parseInt(dotenv.get("ARGON_PARALLELISM"));
        memory = Integer.parseInt(dotenv.get("ARGON_MEMORY"));
        iterations = Integer.parseInt(dotenv.get("ARGON_ITERATIONS"));

    }
}
