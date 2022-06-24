package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.MarkerVO;

@Repository
@Mapper
public interface MarkerMapper {
	public void insert(MarkerVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MarkerVO obj) throws Exception;
	public MarkerVO select(int id) throws Exception;
	public List<MarkerVO> selectall() throws Exception;
}
