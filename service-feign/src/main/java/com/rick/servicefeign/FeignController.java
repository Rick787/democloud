package com.rick.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    /**
     * 编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
     */
    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("/hi")
    public String hiFromFeign(@RequestParam(value = "name",defaultValue = "111") String name){
        return feignInterface.SayHiFromClient(name + " | feign");
    }

}
