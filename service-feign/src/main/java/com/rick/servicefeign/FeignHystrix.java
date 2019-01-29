package com.rick.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrix implements FeignInterface{

    @Override
    public String SayHiFromClient(String name) {
        return "error occurs, sorry" + name;
    }
}
