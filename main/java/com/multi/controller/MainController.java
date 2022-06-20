package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("center", "about/center");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("center", "user/login");
		return "index";
	}
	
	@RequestMapping("/join")
	public String join(Model m) {
		m.addAttribute("center", "user/join");
		return "index";
	}
	
	@RequestMapping("/findid")
	public String findid(Model m) {
		m.addAttribute("center", "user/findid");
		return "index";
	}
	
}
