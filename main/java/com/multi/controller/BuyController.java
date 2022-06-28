package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.biz.BuyBiz;
import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.BuyVO;
import com.multi.vo.BuypageVO;
import com.multi.vo.CustVO;

@Controller
@RequestMapping("/shop/order")
public class BuyController {
	
	@Autowired
	CartBiz crtbiz;
	
	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CustBiz cbiz;
	
	@Autowired
	BuyBiz bbiz;
	
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

	
	@RequestMapping("")
	public String order(Model m, BuypageVO b, String uid, HttpSession session) {
		
		try {
			m.addAttribute("crtlist", bbiz.selectpinfo(b.getOrders()));
			m.addAttribute("cust", cbiz.get(uid));
			m.addAttribute("center", "buy/checkout");
			System.out.println(bbiz.selectpinfo(b.getOrders()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/checkpoint")
	public String checkpoint(String point, String uid) {
		String result = "";
		
		try {
			int intpoint = Integer.parseInt(point);
			CustVO c = cbiz.get(uid);
			int cpoint = c.getPoint();
			
			if(cpoint <= intpoint ) {
				result = "2";
			}else if(intpoint  < 0) {
				result = "0";
			}else if(intpoint  > 0 & intpoint  <= cpoint){
				result = "1";
			}else {
				result = "3";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "3";
		}
		return result;
	}
	
	@RequestMapping("/placeorder")
	public String placeorder(BuyVO obj) {
		System.out.println(obj);
		try {
			bbiz.register(obj);
			System.out.println(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/index";
	}
	
	
	
	
}
