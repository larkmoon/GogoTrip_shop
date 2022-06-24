package com.multi.commu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.CommuVO;

@SpringBootTest
class CommuInsertTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		CommuVO c = new CommuVO("id03", "정보", "담양 죽녹원 정보", "죽녹원정보내용", "전남", null, null);
		try {
			biz.register(c);
			System.out.println(c + "Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
