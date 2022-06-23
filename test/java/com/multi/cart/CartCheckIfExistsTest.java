package com.multi.cart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
class CartCheckIfExistsTest {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		try {
			CartVO c = biz.checkifexists("id01", 2);
			System.out.println(c);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
