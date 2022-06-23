package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;

@SpringBootTest
class CustDeleteTest {

	@Autowired
	CustBiz biz;
	
	@Test
	void contextloads() {
		try {
			biz.remove("id04");
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
