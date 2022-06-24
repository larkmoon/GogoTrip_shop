package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.CartVO;

@Repository
@Mapper
public interface CartMapper {
	public void insert(CartVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(CartVO obj) throws Exception;
	public void updatecnt(CartVO obj) throws Exception;
	public void updatesameid(CartVO obj) throws Exception;
	
	public CartVO select(int id) throws Exception;
	public List<CartVO> selectall() throws Exception;
	public int selectcartcnt(String uid) throws Exception;
	public List<CartVO> selectbyuid(String uid) throws Exception;
	public CartVO checkifexists(String uid, int pid) throws Exception;
}
