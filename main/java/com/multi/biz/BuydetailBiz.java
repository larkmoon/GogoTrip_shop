package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.BuydetailMapper;
import com.multi.vo.BuydetailVO;

@Service
public class BuydetailBiz implements Biz<Integer, BuydetailVO> {

	@Autowired
	BuydetailMapper dao;
	
	
	@Override
	public void register(BuydetailVO v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);		
	}

	@Override
	public void modify(BuydetailVO v) throws Exception {
		dao.update(v);		
	}

	@Override
	public BuydetailVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<BuydetailVO> get() throws Exception {
		return dao.selectall();
	}
	
}
