package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@SpringBootTest
class AdminInsertTest {

	@Autowired
	AdminBiz biz;
	
	@Test
	void contextloads() {
		AdminVO obj = new AdminVO("admin01", "pwd01", "J", "admin");
		try {
			biz.register(obj);
			System.out.println(obj + "Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
