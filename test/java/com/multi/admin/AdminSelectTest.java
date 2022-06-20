package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@SpringBootTest
class AdminSelectTest {

	@Autowired
	AdminBiz biz;
	
	@Test
	void contextloads() {
		try {
			AdminVO obj = biz.get("admin01");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
