package com.allweing.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auther: zzzgyu
 */

@SpringBootApplication
@EnableSwagger2
public class EasyexcelApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EasyexcelApplication.class, args);
    }
}
