package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class CustSelectTest {

	@Autowired
	CustBiz biz;
	
	@Test
	void contextloads() {
		try {
			CustVO obj = biz.get("id04");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
