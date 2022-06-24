package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.MarkerMapper;
import com.multi.vo.MarkerVO;

@Service("markerbiz")
public class MarkerBiz implements Biz<Integer, MarkerVO> {

	@Autowired
	MarkerMapper dao;
	
	@Override
	public void register(MarkerVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(MarkerVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public MarkerVO get(Integer k) throws Exception {		
		return dao.select(k);
	}

	@Override
	public List<MarkerVO> get() throws Exception {
		return dao.selectall();
	}

}
