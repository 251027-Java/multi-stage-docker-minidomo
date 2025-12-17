package com.revature.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerLabApp {

    public static void main(String[] args) {
        SpringApplication.run(DockerLabApp.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Docker!";
    }

    @GetMapping("/")
    public String home() {
        return "Docker Lab Application - Running!";
    }
}
