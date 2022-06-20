package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@RequestMapping("/all")
	public String main(Model m) {
		m.addAttribute("center", "shop/center");
		return "index";
	}

}
