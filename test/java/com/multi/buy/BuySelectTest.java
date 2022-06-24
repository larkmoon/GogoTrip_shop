package com.multi.buy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
class BuySelectTest {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		CartVO obj = null;
		try {
			obj = biz.get(1);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
