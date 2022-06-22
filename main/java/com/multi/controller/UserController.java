package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center", "user/mypage");
		return "index";
	}
	
	@RequestMapping("/userinfo")
	public String userinfo(Model m) {
		m.addAttribute("center", "user/userinfo");
		return "index";
	}

}
