package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CateBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CateVO;
import com.multi.vo.ProductVO;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CateBiz ctbiz;
	
	@RequestMapping("/")
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

}
