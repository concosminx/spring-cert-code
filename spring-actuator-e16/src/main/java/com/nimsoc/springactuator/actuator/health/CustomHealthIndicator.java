package com.nimsoc.springactuator.actuator.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Autowired
    private MetricsEndpoint metricsEndpoint;


    @Override
    public Health health() {
        //base health on metrics if u want
        return Health.up().withDetail("sumo", "orange").build();
    }


}
