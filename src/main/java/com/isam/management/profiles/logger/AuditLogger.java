package com.isam.management.profiles.logger;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Profile("audit") // Solo se creará cuando el perfil "audit" esté activo
public class AuditLogger {

    private static final Logger logger = LoggerFactory.getLogger(AuditLogger.class);

    public void log(String eventType, String username, String details) {
        String auditMessage = String.format(
                "[AUDIT] Event: %s | User: %s | Details: %s",
                eventType,
                username,
                details);

        logger.info(auditMessage);

    }

    public void logSecurityEvent(String action, String principal) {
        log("SECURITY_" + action, principal, "");
    }
}