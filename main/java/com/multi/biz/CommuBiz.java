package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.CommuMapper;
import com.multi.vo.CommuVO;

@Service("commubiz")
public class CommuBiz implements Biz<Integer, CommuVO>{
	
	@Autowired
	CommuMapper dao;

	@Override
	public void register(CommuVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CommuVO v) throws Exception {
		dao.update(v);;
	}

	@Override
	public CommuVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CommuVO> get() throws Exception {
		return dao.selectall();
	}

}
