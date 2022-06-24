package com.multi.marker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MarkerBiz;
import com.multi.vo.MarkerVO;

@SpringBootTest
class MarkerSelectTest {
	
	@Autowired
	MarkerBiz biz;
	
	@Test
	void contextloads() {
		try {
			MarkerVO obj = biz.get(10);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
