package com.sanjeev.spring.boot.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sanjeev.spring.boot.exception.ContactServiceException;

/**
 * @author Sanjeev Saxena
 *
 */

@Component
public class HealthCheckService {

    private final Logger log = LoggerFactory.getLogger(HealthCheckService.class);

    public Map<String, Object> getHealthStatus() {
        try {
            JSONObject result = new JSONObject();
            result.put("HostName", InetAddress.getLocalHost().getHostName());
            result.put("Host IP", InetAddress.getLocalHost().getHostAddress());
            return result.toMap();
        }
        catch (UnknownHostException ex) {
            throw new ContactServiceException("Failed to get health status");
        }
    }
}
