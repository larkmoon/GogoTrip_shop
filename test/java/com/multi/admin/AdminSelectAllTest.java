package com.multi.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@SpringBootTest
class AdminSelectAllTest {

	@Autowired
	AdminBiz biz;
	
	@Test
	void contextloads() {
		try {
			List<AdminVO> list = biz.get();
			for (AdminVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
