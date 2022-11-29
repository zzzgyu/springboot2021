package com.allweing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther: zzzgyu
 */

@SpringBootApplication
@MapperScan("com.allweing.mapper")
public class SecurityApplication {
	public static void main( String[] args ) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
