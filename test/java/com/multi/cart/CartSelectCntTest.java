package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;

@SpringBootTest
class CartSelectCntTest {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		try {
			int cnt = biz.getcartcnt("id01");
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
