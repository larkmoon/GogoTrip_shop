package com.multi.commu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.CommuVO;

@SpringBootTest
class CommuSelectByLocTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		try {
			List<CommuVO> list1 = biz.getbyloc("제주");
			List<CommuVO> list2 = biz.getbyloc("경남");
			List<CommuVO> list3 = biz.getbyloc("서울");
			List<CommuVO> list4 = biz.getbyloc("광주");
			
			for (CommuVO obj : list1) {
				System.out.println(obj);
			}
			
			for (CommuVO obj : list2) {
				System.out.println(obj);
			}
			
			for (CommuVO obj : list3) {
				System.out.println(obj);
			}
			
			for (CommuVO obj : list4) {
				System.out.println(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
