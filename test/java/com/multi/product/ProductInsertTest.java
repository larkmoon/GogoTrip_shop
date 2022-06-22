package com.multi.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ProductBiz;
import com.multi.vo.ProductVO;

@SpringBootTest
class ProductInsertTest {

	@Autowired
	ProductBiz biz;
	
	@Test
	void contextloads() {
		ProductVO obj = new ProductVO("Travel Backpack", 30000, 12, 10, null, null);
		ProductVO obj2 = new ProductVO("크로스백", 10000, 13, 10, null, null);
		ProductVO obj3 = new ProductVO("손톱깎이", 1500, 21, 10, null, null);
		ProductVO obj4 = new ProductVO("뽀로로밴드", 2000, 22, 10, null, null);
		ProductVO obj5 = new ProductVO("안전지갑", 2000, 23, 10, null, null);
		ProductVO obj6 = new ProductVO("여권커버", 12000, 31, 10, null, null);
		ProductVO obj7 = new ProductVO("휴대용 어댑터", 23000, 32, 10, null, null);
		ProductVO obj8 = new ProductVO("귀마개", 12000, 33, 10, null, null);
		try {
			biz.register(obj2);
			biz.register(obj3);
			biz.register(obj4);
			biz.register(obj5);
			biz.register(obj6);
			biz.register(obj7);
			biz.register(obj8);
			System.out.println("Inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
