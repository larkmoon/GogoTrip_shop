package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class CustUpdatePointTest {

	@Autowired
	CustBiz biz;
	
	@Test
	void contextloads() {
		CustVO obj = new CustVO("id01", 3000);
		try {
			biz.updatepoint(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}