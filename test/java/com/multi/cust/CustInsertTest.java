package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class CustInsertTest {

	@Autowired
	CustBiz biz;
	
	@Test
	void contextloads() {
		CustVO obj = new CustVO("id04", "pwd04", "이진만", "jm@naver.com", "01042424242", 32141, "호수로 2", "301호");
		try {
			biz.register(obj);
			System.out.println(obj + "Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
