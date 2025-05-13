package com.isam.management.profiles.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String name;
    private String environment;
    private DbConfig db;

    @Data
    public static class DbConfig {
        private String url;
        private String username;
        private String password;
    }
}
