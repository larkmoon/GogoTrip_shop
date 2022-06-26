package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CustVO;

@Controller
@RequestMapping("/shop/buy")
public class BuyController {
	
	@Autowired
	CartBiz crtbiz;
	
	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CustBiz cbiz;

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
	
	@RequestMapping("/checkout")
	public String checkout(Model m, String uid, HttpSession session) {
		Object ss = session.getAttribute("logincust");
				
		if(ss != null) {			
			try {
				CustVO cust = cbiz.get(uid);
				if(cust.toString().equals(ss.toString())) {
					m.addAttribute("cust", cust);
					m.addAttribute("center","buy/center");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}else {
			m.addAttribute("center", "user/login");
		}
		return "index";
	}
	
	
	
	
}
