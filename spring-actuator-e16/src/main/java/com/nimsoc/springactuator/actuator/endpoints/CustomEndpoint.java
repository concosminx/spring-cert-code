package com.nimsoc.springactuator.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {

    @ReadOperation
    public String test() {
        return ":-)";
    }

}
