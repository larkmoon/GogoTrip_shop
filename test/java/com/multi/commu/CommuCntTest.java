package com.multi.commu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;

@SpringBootTest
class CommuCntTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		try {
			int a = biz.getallcnt();
			int b = biz.getcnt("정보");
			int c = biz.getcnt("후기");
			int d = biz.getcnt("추천");
			
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
