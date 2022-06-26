package com.multi.mapper;

import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.BuydetailVO;

@Repository
@Mapper
public interface BuydetailMapper {
	public void insert(BuydetailVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(BuydetailVO obj) throws Exception;
	
	public BuydetailVO select(int id) throws Exception;
	public List<BuydetailVO> selectall() throws Exception;
	
	public List<BuydetailVO> selectoid(int oid) throws Exception;
}
