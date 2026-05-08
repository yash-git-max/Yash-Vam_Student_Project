package org.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/health")
    public String health() {
        return "App is Running now Thank you use this " +
                "http//<ip>:8081/swagger-ui/index.html";
    }
}

