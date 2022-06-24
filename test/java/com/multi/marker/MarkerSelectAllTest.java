package com.multi.marker;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MarkerBiz;
import com.multi.vo.MarkerVO;

@SpringBootTest
class MarkerSelectAllTest {
	
	@Autowired
	MarkerBiz biz;
	
	@Test
	void contextloads() {
		try {
			List<MarkerVO> list = biz.get();
			for (MarkerVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
