package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CustVO;

@Repository
@Mapper
public interface CustMapper {
	public void insert(CustVO obj) throws Exception;
	public void delete(String id) throws Exception;
	public void update(CustVO obj) throws Exception;	
	public CustVO select(String id) throws Exception;
	public CustVO selectbyemail(String email) throws Exception;
	public List<CustVO> selectall() throws Exception;
	public void updatepoint(CustVO obj) throws Exception;
	
	// yunchanbin
	public CustVO selectemail(String email) throws Exception;
	public CustVO selectphone(String phone) throws Exception;
	
	// for delete: buy.uid -> null
	public List<Integer> selectUpdlist(String id) throws Exception;
	public void nullBD(int id) throws Exception;
}
