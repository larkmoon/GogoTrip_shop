package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multi.biz.CommuBiz;
import com.multi.frame.Util;
import com.multi.vo.CommuVO;
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
	
	@RequestMapping("/add")
	public String add(Model m) {
		m.addAttribute("center", "commu/add");
		return "index";
	}
	
	@RequestMapping("/addimpl")
	public String addimpl(@RequestParam(value = "mf", required = false)MultipartFile mf, CommuVO obj, Model m) {
		String imgname = obj.getMf().getOriginalFilename();
		obj.setImgname(imgname);
		try {
			biz.register(obj);
			Util.saveFile(obj.getMf(), admindir, userdir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, int id) {
		try {
			CommuVO obj = biz.get(id);
			m.addAttribute("dpost", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "commu/detail");
		return "index";
	}
	
	@RequestMapping("/update")
	public String update(Model m, int id) {
		try {
			CommuVO obj = biz.get(id);
			m.addAttribute("dpost", obj);
			List<TypeVO> typelist = biz.gettype();
			m.addAttribute("typelist", typelist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "commu/update");
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
			biz.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail?id=" + obj.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(Model m, int id) {
		try {
			biz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:";
	}
}
