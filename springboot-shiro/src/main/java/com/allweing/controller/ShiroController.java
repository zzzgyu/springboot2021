package com.allweing.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: zzzgyu
 */
@Controller
public class ShiroController {

	@RequestMapping("/index")
	public String requestIndex() {
		return "index";
	}

	@RequestMapping("/pages/home")
	public String requestHome() {
		return "pages/home";
	}

	@RequestMapping("/pages/user")
	public String requestUser() {
		return "pages/user";
	}

	@RequestMapping("/tologin")
	public String requestToLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String requestLogin(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			return "index";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "login";
		}
	}


}
