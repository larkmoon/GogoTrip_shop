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
import com.multi.vo.CustVO;

@Controller
public class UserController {
	
	@Autowired
	CustBiz cbiz;
	
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
	
	@RequestMapping("/login")
	public String login(Model m, String msg, String returnUrl) {
		if(msg != null && msg.equals("w")) {
			m.addAttribute("loginmsg", "아이디와 비밀번호가 일치하지 않습니다.");
		}else if(msg != null && msg.equals("n")) {
			m.addAttribute("loginmsg", "ID가 존재하지 않습니다.");
		}
		
		if(returnUrl != null) {
			System.out.println("login" + returnUrl);
			String returnUrl2 = returnUrl;
			m.addAttribute("returnUrl", returnUrl2);
		}
		m.addAttribute("center", "user/login");
		return "index";
		
	}
	
	@RequestMapping("/mypost")
	public String mypost(Model m, String id) {
		m.addAttribute("center", "user/mypost");
		return "index";
	}
	
	
	@RequestMapping("/loginimpl")
	public String loginimpl(String id, String pwd, String returnUrl, HttpSession session, Model m) {
		try {
			CustVO obj = cbiz.get(id);
			if(obj != null) {
				if(obj.getPwd().equals(pwd)) {
					session.setAttribute("logincust", obj);
					m.addAttribute("logincust", obj);
					if(returnUrl != null) {
						return "redirect:/"+returnUrl;
					}else {
						return "index";
					}

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
	
	@ResponseBody
	@RequestMapping("/findidbyemail")
	public String findidbyemail(String email) {
		String result = "";
		try {
			CustVO obj = cbiz.getbyemail(email);
			if(obj != null) {
				result = obj.getId();
			}else {
				result = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/findpwdbyid")
	public String findpwdbyid(String id) {
		String result = "";
		try {
			CustVO obj = cbiz.get(id);
			if(obj != null) {
				result = obj.getPwd();
			}else {
				result = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	// yunchanbin
	
	@RequestMapping("/registerimpl")
	public String delete(Model m, CustVO obj) {
		int f = 0;
		try {
			cbiz.register(obj);
			f = 0;
		} catch (Exception e) {
			e.printStackTrace();
			f = 1;
		}
		return "redirect:registerok?f="+f;
	}
	
	@RequestMapping("registerok")
	public String registerok(Model m, int f) {
		m.addAttribute("f",f);
		m.addAttribute("center","user/registerok");
		return "index";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center", "user/mypage");
		return "index";
	}
	
	@RequestMapping("/userinfo")
	public String userinfo(Model m,String id) {
		CustVO obj = null;
		try {
			obj = cbiz.get(id);
			m.addAttribute("custvalue",obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("center", "user/userinfo");
		return "index";
	}

	
	@RequestMapping("/userupdateimpl")
	public String userdelete(Model m, CustVO obj) {
		try {
			cbiz.modify(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:mypage?id="+obj.getId();
	}
	
	@RequestMapping("userdelete")
	public String delete(Model m, String id, HttpSession session) {
		List<Integer> blist = null;
		List<Integer> clist = null;
		try {
			if(session != null) {
				session.invalidate();
			}
			blist = cbiz.getUpdlist(id);
			clist = cbiz.getUpdlist_c(id);
			for (Integer b : blist) {
				cbiz.nullBeforeDelete(b);
			}
			for (Integer c : clist) {
				cbiz.nullBeforeDelete_c(c);
			}
			cbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
}
