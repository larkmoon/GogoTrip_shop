package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.biz.CartBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CustVO;
import com.multi.vo.SumVO;

@Controller
@RequestMapping("/shop/cart")
public class CartController {
	
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
	
	@RequestMapping("")
	public String cartmain(Model m, HttpSession session, String id) {
		
		Object ss = session.getAttribute("logincust");
		
		if(ss != null) {
			try {
				CustVO c = cbiz.get(id);				
				if(ss.toString().equals(c.toString())) {
					List<CartVO> list = crtbiz.getbyuid(id);
					SumVO obj = crtbiz.gettotalp(id);
					int osum = obj.getSum();
					m.addAttribute("crtlist", list);
					m.addAttribute("sum", osum);
					m.addAttribute("center", "cart/center");
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			m.addAttribute("center", "user/login");
		}
		return "index";
	}
	
	@RequestMapping("/delete")
	public String delete(Model m, String uid, int ctid) {
		try {
			crtbiz.remove(ctid);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return "redirect:?id="+uid;
	}
	
	@ResponseBody
	@RequestMapping("/updatecart")
	public int updatecart(int qt, int ctid, String uid) {
		int sprice = 0;
		try {
			CartVO obj = new CartVO(ctid, qt);
			crtbiz.modifycnt(obj);
			CartVO obj2 = crtbiz.get(ctid);
			sprice = obj2.getSprice();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sprice;
	}
	
	@ResponseBody
	@RequestMapping("/carttotal")
	public int carttotal(String uid) {
		int sum = 0;
		try {
			SumVO obj = crtbiz.gettotalp(uid);
			sum = obj.getSum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	
	
	
}
