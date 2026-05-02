package com.example.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
                "app", "lab-java-cicd",
                "author", "dungnd",
                "message", "Xin chào! Đây là project CI/CD của dungnd",
                "status", "running",
                "version", "0.0.1"
        );
    }
}
