package com.allweing.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther: zzzgyu
 */
//@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers( ViewControllerRegistry registry ) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/hello").setViewName("hello");
	}

}