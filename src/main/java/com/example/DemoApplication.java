package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@SpringBootApplication
@RestController
public class DemoApplication {

    private static int twoMin = 1000 * 120;

    @RequestMapping(value="/sync")
    public String sync() throws InterruptedException {
        Thread.sleep(twoMin);
        return "Hello!";
    }

    @RequestMapping(value="defered")
    public DeferredResult<String> defered() {
        final DeferredResult<String> result = new DeferredResult<>((long) (twoMin + 1000));
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(twoMin);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.setResult("Hello from another thread!");
            }
        }.start();

        System.out.println("Started");
        return result;


    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
