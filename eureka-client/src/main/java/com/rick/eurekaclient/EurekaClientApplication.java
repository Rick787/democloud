package com.rick.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;


	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "rick") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	/**
     * 每个client注册到eureka-server里面之后都可以被调用
     * 所以现在在eureka-client这个工程里面可以调用SERVICE-RIBBON的服务*/
	@GetMapping("/hi2")
    public String home2(@RequestParam(value = "name", defaultValue = "123") String name){
	    return restTemplate.getForObject("http://SERVICE-RIBBON/hi/ribbon?name="+name,String.class);
    }

}

