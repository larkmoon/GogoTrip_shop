package com.multi.buydetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuydetailBiz;
import com.multi.vo.BuydetailVO;

@SpringBootTest
class BuydetailUpdateTest {

	@Autowired
	BuydetailBiz biz;
	
	@Test
	void contextLoads() {
		BuydetailVO obj = new BuydetailVO(1,1,3,2);
		try {
			biz.modify(obj);
			System.out.println("complete ...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
