package com.multi.marker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MarkerBiz;
import com.multi.vo.MarkerVO;

@SpringBootTest
class MarkerDeleteTest {
	
	@Autowired
	MarkerBiz biz;
	
	@Test
	void contextloads() {
		try {
			biz.remove(13);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
