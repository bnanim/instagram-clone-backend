package com.app.instagramclonebackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InstagramCloneBackendApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(InstagramCloneBackendApplication.class, args);
    }
}