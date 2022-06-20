package com.multi.commu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;

@SpringBootTest
class CommuDeleteTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		try {
			biz.remove(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
