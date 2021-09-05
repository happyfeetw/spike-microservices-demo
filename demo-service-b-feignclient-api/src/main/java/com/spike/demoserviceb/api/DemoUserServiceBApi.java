package com.spike.demoserviceb.api;

import com.spike.demoserviceb.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * date: 2021/9/2
 * author: Spike
 * description:
 */
@FeignClient(
        name = "spike",
        contextId = "spike-api"
)
@Validated
public interface DemoUserServiceBApi {

    @GetMapping("")
    UserDto getUser();
}

