package com.senior.care.senior.care.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RootUserConfig {
    private final String rootUsername;
    private final String rootName;
    private final String rootPassword;

    public RootUserConfig() {
        Dotenv dotenv = Dotenv.load();
        rootUsername = dotenv.get("ROOT_USERNAME");
        rootName = dotenv.get("ROOT_NAME");
        rootPassword = dotenv.get("ROOT_PASSWORD");
    }
}
