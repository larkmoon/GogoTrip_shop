package com.multi.marker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MarkerBiz;
import com.multi.vo.MarkerVO;

@SpringBootTest
class MarkerInsertTest {
	
	@Autowired
	MarkerBiz biz;
	
	@Test
	void contextloads() {
		MarkerVO obj = new MarkerVO(8, "일민미술관", 37.569784, 126.977664);
		try {
			biz.register(obj);
			System.out.println(obj + "Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
