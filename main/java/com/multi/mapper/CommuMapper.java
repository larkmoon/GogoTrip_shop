package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CommuVO;
import com.multi.vo.LocVO;

@Repository
@Mapper
public interface CommuMapper {
	public void insert(CommuVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(CommuVO obj) throws Exception;
	public CommuVO select(int id) throws Exception;
	public List<CommuVO> selectall() throws Exception;
	public List<CommuVO> selectlist() throws Exception;
	public int selectallcnt() throws Exception;
	public int selectcnt(String type) throws Exception;
	public List<LocVO> selectloc() throws Exception;
	public List<CommuVO> selectbytype(String type) throws Exception;
	public List<CommuVO> selectbyloc(String location) throws Exception;
}
