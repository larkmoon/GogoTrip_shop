package com.multi.buy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuyBiz;
import com.multi.vo.BuyVO;

@SpringBootTest
class BuyInsertTest {

	@Autowired
	BuyBiz biz;
	
	@Test
	void contextLoads() {
		BuyVO obj = new BuyVO(0,"id01","hwang", 20000,"Seoul",null,"01099999999",100000,"card",null);
		try {
			biz.register(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
