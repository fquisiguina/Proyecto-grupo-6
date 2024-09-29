package com.msf.movement.middleend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MovementMiddleendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovementMiddleendApplication.class, args);
    }

}
