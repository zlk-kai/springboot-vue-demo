package com.ybzyq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloword {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}
