package com.multi.buydetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuydetailBiz;
import com.multi.vo.BuydetailVO;

@SpringBootTest
class BuydetailSelectTest {

	@Autowired
	BuydetailBiz biz;
	
	@Test
	void contextLoads() {
		BuydetailVO obj = null;
		try {
			obj = biz.get(1);	
			System.out.println(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
