package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.CustMapper;
import com.multi.vo.CustVO;

@Service("custbiz")
public class CustBiz implements Biz<String, CustVO> {

	@Autowired
	CustMapper dao;
	
	@Override
	public void register(CustVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CustVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public CustVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CustVO> get() throws Exception {
		return dao.selectall();
	}
	
	public CustVO getbyemail(String email) throws Exception {
		return dao.selectbyemail(email);
	}
	
	public void updatepoint(CustVO obj) throws Exception{
		dao.updatepoint(obj);
	}

	// yunchanbin
	public CustVO getemail(String email) throws Exception {
		return dao.selectemail(email);
	}
	
	public CustVO getphone(String phone) throws Exception {
		return dao.selectphone(phone);
	}
}
