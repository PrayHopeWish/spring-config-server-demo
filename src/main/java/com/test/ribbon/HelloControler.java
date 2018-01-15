/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author star
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;
    
    @Autowired
    HelloServiceHystrix helloServiceHystrix;
    
    
    // http://localhost:8864/hystrix brower the dashbord need remove the beloe config.
    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/hello/hystrix")
    public String hiHystrix(@RequestParam String name){
        return helloServiceHystrix.hiService(name);
    }

}
