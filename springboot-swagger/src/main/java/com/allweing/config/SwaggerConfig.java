package com.allweing.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auther: zzzgyu
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket webApiConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("springboot")
				.apiInfo(webApiInfo())
				.select()
				//.paths(Predicates.not(PathSelectors.regex("/admin/.*")))
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();

	}

	private ApiInfo webApiInfo(){

		return new ApiInfoBuilder()
				.title("API测试文档")
				.description("服务接口测试")
				.version("1.0")
				.contact(new Contact("java", "http://www.baidu.com", "1123@qq.com"))
				.build();
	}
}
