package com.multi.buydetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuydetailBiz;
import com.multi.vo.BuydetailVO;

@SpringBootTest
class BuydetailSelectOidTest {

	@Autowired
	BuydetailBiz biz;
	
	@Test
	void contextLoads() {
		List<BuydetailVO> obj = null;
		try {
			obj = biz.getoid(4);	
			System.out.println(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
