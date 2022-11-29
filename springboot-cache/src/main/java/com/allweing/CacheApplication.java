package com.allweing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @auther: zzzgyu
 */

@SpringBootApplication
@MapperScan("com.allweing.mapper")
@EnableCaching
@EnableAsync
public class CacheApplication {
    public static void main( String[] args ) {
        SpringApplication.run(CacheApplication.class, args);
    }
}
