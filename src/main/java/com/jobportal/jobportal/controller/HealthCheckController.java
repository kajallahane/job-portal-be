package com.jobportal.jobportal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public String healthcheck() {
        return "App is working fine";
    }
}
