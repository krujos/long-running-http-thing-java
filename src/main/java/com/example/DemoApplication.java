package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class DemoApplication {

    @RequestMapping(value="/")
    public String root() {
        return "Hello"
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
