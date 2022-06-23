package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
class CartUpdateCntTest {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		CartVO obj = new CartVO(23, 2);
		try {
			biz.modifycnt(obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
