package com.isam.management.profiles.controller;

import com.isam.management.profiles.config.AppConfig;
import com.isam.management.profiles.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private AppConfig appConfig;

    @Autowired(required = false)
    private AuditService auditService;

    @GetMapping("/profile-info")
    public String getProfileInfo() {
        if (auditService != null) {
            auditService.createUser("Isam");
        }

        return String.format(
                "<h2> App Name: %s </h2> " +
                        "<h3>Environment: %s</h3> " +
                        "<h3>DB URL: %s </h3>" +
                        "<h3>DB User: %s</h3>",

                appConfig.getName(),
                appConfig.getEnvironment(),
                appConfig.getDb().getUrl(),
                appConfig.getDb().getUsername()
        );
    }

}
