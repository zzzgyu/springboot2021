package com.allweing.controller;

import com.allweing.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @auther: zzzgyu
 */

@RestController
@CrossOrigin
@Log4j2
public class TestController {


	@GetMapping("/users")
	public List<User> getUsers() {

		ArrayList<User> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			User user = new User();
			user.setAge(i);
			user.setName(UUID.randomUUID().toString().substring(0, 4));
			if (i % 2 == 0) {
				user.setSex("男");
			} else {
				user.setSex("女");
			}
			list.add(user);
		}

		return list;
	}

	@GetMapping("/user")
	public String getUser(Model model) {
		log.info("-------------"+model);

		return "user";
	}

}
