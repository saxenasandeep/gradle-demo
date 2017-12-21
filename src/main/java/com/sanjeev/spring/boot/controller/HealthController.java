package com.sanjeev.spring.boot.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeev.spring.boot.service.HealthCheckService;

/**
 * @author Sanjeev Saxena
 *
 */

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class HealthController {

    private final Logger log = LoggerFactory.getLogger(HealthController.class);

    @Autowired
    private HealthCheckService healthCheck;

    @GetMapping(value = "/")
    public ResponseEntity<Map<String, Object>> serviceHealthCheck() {
        log.info("Health check api requested");
        return new ResponseEntity<Map<String, Object>>(healthCheck.getHealthStatus(), HttpStatus.OK);
    }
}