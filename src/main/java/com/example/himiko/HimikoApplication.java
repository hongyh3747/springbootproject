package com.example.himiko;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.himiko.dao")
public class HimikoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HimikoApplication.class, args);
    }

}
