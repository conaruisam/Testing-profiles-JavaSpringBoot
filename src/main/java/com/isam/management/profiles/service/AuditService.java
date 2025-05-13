package com.isam.management.profiles.service;

import com.isam.management.profiles.logger.AuditLogger;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("audit")
@AllArgsConstructor
public class AuditService {

    private AuditLogger auditLogger;

    public void createUser(String createdBy) {
        if (auditLogger != null) {
            auditLogger.log("USER_CREATED", createdBy,
                    "Created user: " + " Isam.");
        }
    }
}