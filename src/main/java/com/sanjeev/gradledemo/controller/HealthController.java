package com.sanjeev.gradledemo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeev.gradledemo.service.HealthCheckService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @author Sanjeev Saxena
 *
 */

@Api(value = "Health Service")
@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class HealthController {

    @Autowired
    private HealthCheckService healthCheck;

    @ApiOperation(value = "Health Check API")
    @GetMapping(value = "/health")
    public ResponseEntity<Map<String, Object>> serviceHealthCheck() {
        return new ResponseEntity<Map<String, Object>>(healthCheck.getHealthStatus(), HttpStatus.OK);
    }
}