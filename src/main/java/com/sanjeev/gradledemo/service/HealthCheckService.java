package com.sanjeev.gradledemo.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sanjeev.gradledemo.exception.ContactServiceException;

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
            result.put("jvmFreeMemory", Runtime.getRuntime().freeMemory() / 1024 * 1024);
            result.put("jvmTotalMemory", Runtime.getRuntime().totalMemory() / 1024 * 1024);
            result.put("jvmMaxMemory", Runtime.getRuntime().maxMemory() / 1024 * 1024);
            result.put("jvmAvailableProcessor", Runtime.getRuntime().availableProcessors() / 1024 * 1024);
            log.info("service heart beat requested \n{}", result.toString(4));
            return result.toMap();
        }
        catch (UnknownHostException ex) {
            throw new ContactServiceException("Failed to get health status");
        }
    }
}
