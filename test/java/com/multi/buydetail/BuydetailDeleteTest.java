package com.multi.buydetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuydetailBiz;

@SpringBootTest
class BuydetailDeleteTest {

	@Autowired
	BuydetailBiz biz;
	
	@Test
	void contextLoads() {
		
		try {
			biz.remove(2);	
			System.out.println("complete ...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
