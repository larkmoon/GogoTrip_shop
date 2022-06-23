package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CartBiz;
import com.multi.vo.CustVO;

@Controller
public class MainController {

	@Autowired
	CartBiz crtbiz;
	
	@ModelAttribute("cartcnt")
	public int cartcnt(HttpSession session) {
		int cartcnt = 0;
		if(session.getAttribute("logincust") != null) {
			CustVO obj = (CustVO) session.getAttribute("logincust");
			String uid = obj.getId();
			try {
				cartcnt = crtbiz.getcartcnt(uid);			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cartcnt;
	}
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("center", "about/center");
		return "index";
	}
	

	
}
