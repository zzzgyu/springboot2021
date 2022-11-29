package com.allweing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: zzzgyu
 */
@Configuration
@EnableConfigurationProperties(YuProperties.class)
@ConditionalOnWebApplication
public class YuAutoConfiguration {

    @Autowired
    YuProperties yuProperties;

    @Bean
    public YuService yuService() {
        YuService yuService = new YuService(yuProperties);

        return yuService;
    }
}
