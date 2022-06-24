package com.multi.buy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuyBiz;

@SpringBootTest
class BuyDeleteTest {

	@Autowired
	BuyBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(3);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
