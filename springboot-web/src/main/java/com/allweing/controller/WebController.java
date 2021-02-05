package com.allweing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: zzzgyu
 */

@Controller
public class WebController {

    @GetMapping("/home")
    public String home() {
        System.out.println("--------------");
        return "home";
    }
}
