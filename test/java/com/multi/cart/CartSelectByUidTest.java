package com.multi.cart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
class CartSelectByUidTest {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		try {
			List<CartVO> list = biz.getbyuid("id01");
			for (CartVO cartVO : list) {
				System.out.println(cartVO);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
