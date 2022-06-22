package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
class CartInsertTest {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		CartVO obj = new CartVO("id02", 4, 1);
		try {
			biz.register(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
