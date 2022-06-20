package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CommuVO;

@Repository
@Mapper
public interface CommuMapper {
	public void insert(CommuVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(CommuVO obj) throws Exception;
	public CommuVO select(int id) throws Exception;
	public List<CommuVO> selectall() throws Exception;
}
