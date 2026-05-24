package com.hglsys.nodues.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/actuator")
public class HealthCheck {

    @GetMapping("/health")
    public ResponseEntity<?> healthCheck(){
        Map<String, Object> resp= new HashMap<>();
        resp.put("status","UP");
        return ResponseEntity.ok(resp);
    }
}
