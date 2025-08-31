package com.pm.patientservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "Health", description = "Health check endpoints for the patient service")
public class HealthController {

    @GetMapping("/health")
    @Operation(summary = "Check service health", description = "Returns UP if the service is running")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("service", "PATIENT-SERVICE");
        status.put("status", "UP");
        return status;
    }
}
