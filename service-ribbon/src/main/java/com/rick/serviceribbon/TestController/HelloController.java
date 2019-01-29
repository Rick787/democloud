package com.rick.serviceribbon.TestController;

import com.rick.serviceribbon.TestService.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name",defaultValue = "rick") String name){
        return helloService.hiService(name + " | ribbon");
    }
}
