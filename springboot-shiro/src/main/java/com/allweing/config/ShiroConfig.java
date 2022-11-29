package com.allweing.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @auther: zzzgyu
 */
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean( DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();

		/*
		 * anon: 无需认证直接访问
		 * authc: 必须认证了才能访问
		 * user: 必须拥有 记住我才有功能
		 * perms: 拥有对某个资源的权限才能访问
		 * role: 拥有某个角色权限才能访问
		 * */
		hashMap.put("/pages/home", "anon");
		hashMap.put("/pages/user", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(hashMap);
		shiroFilterFactoryBean.setLoginUrl("/tologin");

		return shiroFilterFactoryBean;

	}

	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager( Realm realm ) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager(realm);
		return defaultWebSecurityManager;
	}

	@Bean
	public Realm realm() {
		return new UserRealm();
	}

}
