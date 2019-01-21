package com.rick.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = FeignHystrix.class)
public interface FeignInterface {

    @GetMapping("/hi")
    String SayHiFromClient(@RequestParam("name") String name);

}
