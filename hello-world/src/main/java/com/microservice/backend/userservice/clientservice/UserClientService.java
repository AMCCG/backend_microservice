package com.microservice.backend.userservice.clientservice;

import com.microservice.backend.userservice.config.InternalFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service", configuration = InternalFeignConfig.class)
public interface UserClientService {

    @GetMapping("${app.internal.path.get-users}")
    String getUsers(@RequestHeader HttpHeaders headers);

}