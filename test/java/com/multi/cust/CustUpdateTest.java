package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class CustUpdateTest {

	@Autowired
	CustBiz biz;
	
	@Test
	void contextloads() {
		CustVO obj = new CustVO("pwd04", "이진만", "jm@hanmail.net", "01024242424", 44221, "호수로 2", "301호", "id04");
		try {
			biz.modify(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}