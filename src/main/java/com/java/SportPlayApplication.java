package com.java;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.java.dao")
public class SportPlayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportPlayApplication.class, args);
    }

}
