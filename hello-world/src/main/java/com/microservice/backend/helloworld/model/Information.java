package com.microservice.backend.helloworld.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Information {
    private String greeting;
    private String hostName;
    private String version;
}
