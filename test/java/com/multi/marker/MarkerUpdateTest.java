package com.multi.marker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MarkerBiz;
import com.multi.vo.MarkerVO;

@SpringBootTest
class MarkerUpdateTest {
	
	@Autowired
	MarkerBiz biz;
	
	@Test
	void contextloads() {
		MarkerVO obj = new MarkerVO("일민 미술관", 37.569784, 126.977664, 16);
		try {
			biz.modify(obj);
			System.out.println(obj + "Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
