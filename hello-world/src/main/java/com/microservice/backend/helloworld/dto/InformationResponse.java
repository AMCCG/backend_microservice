package com.microservice.backend.helloworld.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformationResponse {
    private String greeting;
    private String hostName;
    private String version;
}
