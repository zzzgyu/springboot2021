package com.allweing.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @auther: zzzgyu
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure( HttpSecurity http ) throws Exception {
//
//		/*http.authorizeRequests().mvcMatchers("/home", "/").permitAll().anyRequest().authenticated().and()
//				.formLogin().loginPage("/login").permitAll().and()
//				.logout().logoutUrl("/loginout").permitAll();*/
//
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//
//	}

	@Autowired
	UserDetailsService MyUserDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("123456");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password(password).roles("admin");*/

		auth.userDetailsService(MyUserDetailService).passwordEncoder(new BCryptPasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().accessDeniedPage("/hello.html").and()
				.authorizeRequests().anyRequest().authenticated();

	}
}
