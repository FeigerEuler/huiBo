package com.mhh.huibo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mhh")
public class HuiBoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuiBoApplication.class, args);
    }

}
