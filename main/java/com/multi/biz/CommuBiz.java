package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.CommuMapper;
import com.multi.vo.CommuVO;
import com.multi.vo.LocVO;
import com.multi.vo.TypeVO;

@Service("commubiz")
public class CommuBiz implements Biz<Integer, CommuVO>{
	
	@Autowired
	CommuMapper dao;

	@Override
	public void register(CommuVO v) throws Exception {
		dao.insert(v);
	}
	
	public void registernoloc(CommuVO v) throws Exception{
		dao.insertnoloc(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CommuVO v) throws Exception {
		dao.update(v);;
	}
	
	public void modifynoloc(CommuVO v) throws Exception{
		dao.updatenoloc(v);
	}

	@Override
	public CommuVO get(Integer k) throws Exception {
		return dao.select(k);
	}
	
	public CommuVO read(Integer k) throws Exception{
		CommuVO obj = dao.select(k);
		CommuVO obj2 = new CommuVO(k, obj.getViews() + 1);
		dao.increaseviews(obj2);
		return dao.select(k);
	}

	@Override
	public List<CommuVO> get() throws Exception {
		return dao.selectall();
	}
	
	public List<CommuVO> getlist() throws Exception{
		return dao.selectlist();
	}
	
	public int getallcnt() throws Exception{
		return dao.selectallcnt();
	}
	
	public int getcnt(String type) throws Exception{
		return dao.selectcnt(type);
	}
	
	public List<LocVO> getloc() throws Exception{
		return dao.selectloc();
	}
	
	public List<TypeVO> gettype() throws Exception{
		return dao.selecttype();
	}
	
	public List<CommuVO> getbytype(String type) throws Exception{
		return dao.selectbytype(type);
	}
	
	public List<CommuVO> getbyloc(String location) throws Exception{
		return dao.selectbyloc(location);
	}
	
	public List<CommuVO> getbykeyword(CommuVO v) throws Exception{
		return dao.selectbykeyword(v);
	}


}
