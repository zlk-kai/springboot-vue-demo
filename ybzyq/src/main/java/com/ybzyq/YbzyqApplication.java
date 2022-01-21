package com.ybzyq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/ybzyq/mapper")
public class YbzyqApplication {

    public static void main(String[] args) {
        SpringApplication.run(YbzyqApplication.class, args);
    }

}
