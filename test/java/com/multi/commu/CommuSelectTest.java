package com.multi.commu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.CommuVO;

@SpringBootTest
class CommuSelectTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		try {
			CommuVO obj = biz.get(1);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
