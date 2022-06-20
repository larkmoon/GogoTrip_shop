package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping("/")
	public String cartmain(Model m) {
		m.addAttribute("center", "cart/center");
		return "index";
	}
}
