package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multi.biz.CartBiz;
import com.multi.biz.CommuBiz;
import com.multi.biz.CustBiz;
import com.multi.frame.Util;
import com.multi.vo.CommuVO;
import com.multi.vo.CustVO;
import com.multi.vo.LocVO;
import com.multi.vo.TypeVO;

@Controller
@RequestMapping("/community")
public class CommuController {
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	CommuBiz biz;
	
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
	public String all(Model m, String type, String loc) {
		
		if(type == null && loc == null) {
			try {
				List<CommuVO> alllist = biz.getlist();
				m.addAttribute("postlist", alllist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(type != null) {
			try {
				List<CommuVO> typelist = biz.getbytype(type);
				m.addAttribute("postlist", typelist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(loc != null) {
			try {
				List<CommuVO> loclist = biz.getbyloc(loc);
				m.addAttribute("postlist", loclist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		int allcnt;
		int reccnt;
		int infocnt;
		int rvcnt;
		List<LocVO> loclist;
		
		try {
			allcnt = biz.getallcnt();
			reccnt = biz.getcnt("추천");
			infocnt = biz.getcnt("정보");
			rvcnt = biz.getcnt("후기");
			loclist = biz.getloc();
			
			
			m.addAttribute("allcnt", allcnt);
			m.addAttribute("reccnt", reccnt);
			m.addAttribute("infocnt", infocnt);
			m.addAttribute("rvcnt", rvcnt);
			m.addAttribute("loclist", loclist);		
		} catch (Exception e) {
			e.printStackTrace();
		}

		m.addAttribute("right", "commu/right");
		m.addAttribute("center", "commu/center");
		return "index";
	}

	@RequestMapping("/detail")
	public String detail(Model m, int id, HttpSession session) {
		Object ss = session.getAttribute("logincust");		
		if(ss != null) {
			try {
				CommuVO obj = biz.read(id);
				m.addAttribute("logincust", ss);
				m.addAttribute("dpost", obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m.addAttribute("center", "commu/detail");
			return "index";
		}else {
			return "redirect:/login?returnUrl="+"community/detail?id="+id;			
		}

	}
	

	@RequestMapping("/add")
	public String add(Model m, HttpSession session) {
		if(session.getAttribute("logincust") == null) {
			return "redirect:/login?returnUrl="+"community/add";
		}else {
			m.addAttribute("center", "commu/add");
			return "index";
		}		
	}
	
	@RequestMapping("/addimpl")
	public String addimpl(@RequestParam(value = "mf", required = false)MultipartFile mf, CommuVO obj, Model m) {
		String imgname = obj.getMf().getOriginalFilename();
		obj.setImgname(imgname);
		try {
			String loc = obj.getLocation();
			if(loc.equals("")) {
				biz.registernoloc(obj);
			}else {
				biz.register(obj);
			}
			Util.saveFile(obj.getMf(), admindir, userdir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/community";
	}
	
	
	@RequestMapping("/update")
	public String update(Model m, int id, HttpSession session) {
		Object ss = session.getAttribute("logincust");
		if(ss != null) {			
			try {
				CommuVO c = biz.get(id);
				String uid = c.getUid();
				CustVO cust = cbiz.get(uid);
				if(ss.toString().equals(cust.toString())) {					
					m.addAttribute("dpost", c);
					List<TypeVO> typelist = biz.gettype();
					m.addAttribute("typelist", typelist);
					m.addAttribute("center", "commu/update");
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return "index";
	}
	
	@RequestMapping("/updateimpl")
	public String updateimpl(MultipartFile mf, int id, CommuVO obj) {
		String iname = obj.getMf().getOriginalFilename();
		if(!(iname.equals(""))) {
			obj.setImgname(iname);
			Util.saveFile(obj.getMf(), admindir, userdir);
		}
		try {
			String loc = obj.getLocation();
			if(loc.equals("")) {
				biz.modifynoloc(obj);
			}else {
				biz.modify(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail?id=" + obj.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(Model m, int id, HttpSession session) {
		Object ss = session.getAttribute("logincust");
		if(ss != null) {
			CommuVO c;
			try {
				c = biz.get(id);
				String uid = c.getUid();
				CustVO cust = cbiz.get(uid);
				if(cust.toString().equals(ss.toString())) {
					biz.remove(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
				return "redirect:/community";
		}else {
			m.addAttribute("center", "user/login");
			return "index";
		}					
	}

	
	@RequestMapping("/search")
	public String search(String from, String keyword, Model m) throws Exception {
		CommuVO obj = new CommuVO();
		obj.setFrom(from);
		obj.setKeyword(keyword);
		List<CommuVO> searchlist = biz.getbykeyword(obj);
		m.addAttribute("postlist", searchlist);
		m.addAttribute("center", "commu/center");
		m.addAttribute("right", "commu/right");
		return "index";
	}

}
