package com.charlie.eurekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekademoApplication.class, args);
    }

}
