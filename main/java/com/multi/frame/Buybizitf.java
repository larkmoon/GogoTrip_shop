package com.multi.frame;

import java.util.List;

import com.multi.vo.BuypageItemVO;

public interface Buybizitf {
	public List<BuypageItemVO> selectpinfo(List<BuypageItemVO> orders) throws Exception;
}
