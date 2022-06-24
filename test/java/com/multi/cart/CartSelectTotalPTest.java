package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.SumVO;

@SpringBootTest
class CartSelectTotalPTest {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		try {
			SumVO obj = biz.gettotalp("id01");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
