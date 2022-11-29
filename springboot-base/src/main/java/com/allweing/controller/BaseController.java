package com.allweing.controller;

import com.allweing.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: zzzgyu
 */
@Controller
@CrossOrigin
public class BaseController {
	Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String base() {

		LOGGER.trace("-------tract-----------");
		LOGGER.debug("-------debug---------");
		LOGGER.info("----------info-----------");
		LOGGER.warn("-------warn----------");
		LOGGER.error("---------error-----------");
		return "base";
	}

	@GetMapping("user")
	public List<User> getUserList() {
		ArrayList<User> arrayList = new ArrayList<>();
		User user = new User();
		user.setName("lili");
		user.setAge(18);
		User user2 = new User();
		user2.setName("tom");
		user2.setAge(17);
		arrayList.add(user);
		arrayList.add(user2);
		return arrayList;

	}

	@GetMapping("user2")
	@ResponseBody
	public String getString() {
		return "hello############";
	}

	@GetMapping("index")
	public String getIndex() {
		return "index";
	}

	@GetMapping("home")
	public String getHome() {
		System.out.println("================");
		return "forward:1.png";
	}


}
