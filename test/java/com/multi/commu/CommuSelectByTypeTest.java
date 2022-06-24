package com.multi.commu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.CommuVO;

@SpringBootTest
class CommuSelectByTypeTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		try {
			List<CommuVO> infolist = biz.getbytype("정보");
			List<CommuVO> rvlist = biz.getbytype("후기");
			List<CommuVO> reclist = biz.getbytype("추천");
			
			for (CommuVO obj : reclist) {
				System.out.println(obj);
			}
			
			for (CommuVO obj : infolist) {
				System.out.println(obj);
			}
			
			for (CommuVO obj : rvlist) {
				System.out.println(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
