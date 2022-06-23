package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@Controller
public class UserController {
	
	@Autowired
	CustBiz cbiz;
	
	@RequestMapping("/login")
	public String login(Model m, String msg) {
		if(msg != null && msg.equals("w")) {
			m.addAttribute("loginmsg", "아이디와 비밀번호가 일치하지 않습니다.");
		}else if(msg != null && msg.equals("n")) {
			m.addAttribute("loginmsg", "ID가 존재하지 않습니다.");
		}
		m.addAttribute("center", "user/login");
		return "index";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(String id, String pwd, HttpSession session, Model m) {
		try {
			CustVO obj = cbiz.get(id);
			if(obj != null) {
				if(obj.getPwd().equals(pwd)) {
					session.setAttribute("logincust", obj);
					m.addAttribute("logincust", obj);
					return "index";
				}else {
					// 아이디와 비밀번호 일치하지 않음
					return "redirect:/login?msg=w";
				}
			}else {
				// 아이디 존재하지 않음
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/login?msg=n";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(Model m, HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "index";
	}
	
	@RequestMapping("/join")
	public String join(Model m) {
		m.addAttribute("center", "user/join");
		return "index";
	}
	
	@RequestMapping("/findid")
	public String findid(Model m) {
		m.addAttribute("center", "user/findid");
		return "index";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center", "user/mypage");
		return "index";
	}
	
	@RequestMapping("/userinfo")
	public String userinfo(Model m) {
		m.addAttribute("center", "user/userinfo");
		return "index";
	}

}
