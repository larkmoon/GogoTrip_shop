package com.multi.buydetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuydetailBiz;
import com.multi.vo.BuydetailVO;

@SpringBootTest
class BuydetailInsertTest {

	@Autowired
	BuydetailBiz biz;
	
	@Test
	void contextLoads() {
		BuydetailVO obj = new BuydetailVO(0,1,2,1);
		try {
			biz.register(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}