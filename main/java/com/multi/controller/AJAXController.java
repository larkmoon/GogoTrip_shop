package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.AdminBiz;
import com.multi.biz.CateBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@RestController
public class AJAXController {

	@Autowired
	CustBiz cubiz;
	
	@Autowired
	AdminBiz adbiz;
	
	@Autowired
	CateBiz cbiz;
	
	@RequestMapping("/checkid")
	public String custcheckid(String id) {
		CustVO obj = null;
		String result = "";
		
		try {
			obj = cubiz.get(id);
			if(obj == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/checkemail")
	public String custcheckemail(String email) {
		CustVO obj = null;
		String result = "";
		
		try {
			obj = cubiz.getemail(email);
			if(obj == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/checkphone")
	public String custcheckphone(String phone) {
		CustVO obj = null;
		String result = "";
		Double dnum= 0.0;
		
		try {
			dnum = Double.parseDouble(phone);
			obj = cubiz.getphone(phone);
			if(obj == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			System.out.println("exception");
			result = "2";
		}
		System.out.println(dnum);
		return result;
	}
	
}
