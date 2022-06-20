package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AdminBiz;

@SpringBootTest
class AdminIDeleteTest {

	@Autowired
	AdminBiz biz;
	
	@Test
	void contextloads() {
		try {
			biz.remove("admin01");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
