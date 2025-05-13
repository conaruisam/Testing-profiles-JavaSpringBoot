package com.isam.management.profiles.config;

import com.isam.management.profiles.logger.AuditLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("audit")
public class AuditConfig {

    @Bean
    public AuditLogger auditLogger() {
        return new AuditLogger();
    }

    // Otros beans relacionados con auditoría
}