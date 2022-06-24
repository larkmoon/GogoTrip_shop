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
import com.multi.biz.CateBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CartVO;
import com.multi.vo.CateVO;
import com.multi.vo.CustVO;
import com.multi.vo.ProductVO;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CateBiz ctbiz;
	
	@Autowired
	CartBiz crtbiz;
	
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
	public String main(Model m, Integer ct) {
		try {
			if(ct == null) {
				List<ProductVO> allplist = pbiz.get();
				m.addAttribute("plist", allplist);
				List<CateVO> upctlist = ctbiz.getupcate();
				m.addAttribute("upctlist", upctlist);
			}else {
				CateVO obj = ctbiz.get(ct);
				List<ProductVO> dplist;
				if(obj.getUpid() == null) {
					dplist = pbiz.getbyupcate(ct);
					
				}else {
					dplist = pbiz.getbycate(ct);
					m.addAttribute("allid", obj.getUpid());
				}			
				m.addAttribute("plist", dplist);
				List<CateVO> dctlist = ctbiz.getbyupcate(ct);
				m.addAttribute("upctlist", dctlist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "shop/center");
		return "index";
	}
	
	@RequestMapping("/product")
	public String main(Model m, int id) {
		try {
			ProductVO obj = pbiz.get(id);
			m.addAttribute("dproduct", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "shop/detail");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/getprice")
	public int getprice(int qt, int sprice) {
		int mprice = qt * sprice;
		return mprice;
	}
	
	@ResponseBody
	@RequestMapping("/addcart")
	public String addcart(String uid, int pid, int cnt, HttpSession session) {
		String result = "";
		Object ss = session.getAttribute("logincust");	
		if(ss != null) {
			try {
				CartVO ckcrt = crtbiz.checkifexists(uid, pid);
				
				if(ckcrt == null) {
					CartVO obj = new CartVO(uid, pid, cnt);
					crtbiz.register(obj);
				}else {
					// 수량만 update
					int ocnt = ckcrt.getCnt();
					CartVO newcart = new CartVO(uid, pid, ocnt + cnt);
					crtbiz.modifysameid(newcart);
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			result = "1";
		}else {
			result = "0";
		}
		return result;
	}
	
}
	
