package com.breakdown.vehicle_assistance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testApi() {
        return "Vehicle Assistance Backend is Running!";
    }
}