package com.multi.buy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuyBiz;
import com.multi.vo.BuyVO;

@SpringBootTest
class BuyInsertTests {

	@Autowired
	BuyBiz biz;
	
	@Test
	void contextloads() {
		BuyVO obj = new BuyVO(3344534, "id01", "문산하", 67864, "광주광역시 북구", "301호", "01087654321", 2500, 1000, 45000, "무통장입금");
		try {
			biz.register(obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
