package com.multi.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.frame.Buybizitf;
import com.multi.mapper.BuyMapper;
import com.multi.vo.BuyVO;
import com.multi.vo.BuypageItemVO;

@Service("buybiz")
public class BuyBiz implements Biz<Integer, BuyVO>, Buybizitf{

	@Autowired
	BuyMapper dao;

	@Override
	public void register(BuyVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(BuyVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BuyVO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<BuyVO> get() throws Exception {
		return dao.selectall();
	}

	public BuypageItemVO selectpinfo(int pid) throws Exception{
		return dao.selectpinfo(pid);
	};

	@Override
	public List<BuypageItemVO> selectpinfo(List<BuypageItemVO> orders) throws Exception {
		List<BuypageItemVO> list = new ArrayList<BuypageItemVO>();
		for (BuypageItemVO obj : orders) {
			BuypageItemVO pinfo = dao.selectpinfo(obj.getPid());
			pinfo.setCnt(obj.getCnt());
			pinfo.initsale();
			list.add(pinfo);
		}
		return list;
	}
	
	public List<BuyVO> getbyid(String uid) throws Exception{
		return dao.selectbyid(uid);
	}



	
}

	
	
	
