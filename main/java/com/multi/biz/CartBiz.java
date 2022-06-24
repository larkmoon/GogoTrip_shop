package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.CartMapper;
import com.multi.vo.CartVO;
import com.multi.vo.SumVO;

@Service
public class CartBiz implements Biz<Integer, CartVO> {

	@Autowired
	CartMapper dao;
	
	
	@Override
	public void register(CartVO v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);		
	}

	@Override
	public void modify(CartVO v) throws Exception {
		dao.update(v);		
	}
	
	public void modifycnt(CartVO v) throws Exception{
		dao.updatecnt(v);
	}
	
	public void modifysameid(CartVO v) throws Exception{
		dao.updatesameid(v);
	}

	@Override
	public CartVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CartVO> get() throws Exception {
		return dao.selectall();
	}
	
	public int getcartcnt(String uid) throws Exception{
		return dao.selectcartcnt(uid);
	}
	
	public List<CartVO> getbyuid(String uid) throws Exception{
		return dao.selectbyuid(uid);
	}
	
	public CartVO checkifexists(String uid, int pid) throws Exception{
		return dao.checkifexists(uid, pid);
	}
	
	public SumVO gettotalp(String uid) throws Exception{
		return dao.selecttotalp(uid);
	}
	
}
