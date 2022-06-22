package com.multi.buydetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.BuydetailBiz;
import com.multi.vo.BuydetailVO;

@SpringBootTest
class BuydetailSelectAllTest {

	@Autowired
	BuydetailBiz biz;
	
	@Test
	void contextLoads() {
		List<BuydetailVO> list = null;
		try {
			list = biz.get();
			for (BuydetailVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
