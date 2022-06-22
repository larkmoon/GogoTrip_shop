package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CateVO;

@Repository
@Mapper
public interface CateMapper {
	public void insert(CateVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(CateVO obj) throws Exception;	
	public CateVO select(int id) throws Exception;
	public List<CateVO> selectall() throws Exception;
	public List<CateVO> selectupcate() throws Exception;
	public List<CateVO> selectbyupcate(int upid) throws Exception;
}
