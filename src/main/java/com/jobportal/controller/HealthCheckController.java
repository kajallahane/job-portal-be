package com.jobportal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        return new ResponseEntity<String>("App is working fine",HttpStatus.OK);
    }
}
