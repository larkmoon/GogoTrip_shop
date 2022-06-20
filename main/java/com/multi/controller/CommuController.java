package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commu")
public class CommuController {
	
	@RequestMapping("/info")
	public String all(Model m) {
		m.addAttribute("center", "commu/center");
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(Model m) {
		m.addAttribute("center", "commu/add");
		return "index";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m) {
		m.addAttribute("center", "commu/detail");
		return "index";
	}
}
