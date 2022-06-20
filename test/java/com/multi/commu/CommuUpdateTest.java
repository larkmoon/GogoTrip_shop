package com.multi.commu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.CommuVO;

@SpringBootTest
class CommuUpdateTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		CommuVO c = new CommuVO(1, "후기", "제주 여행 후기", "제주도 완전 재미있었다", "제주", null, null);
		try {
			biz.modify(c);
			System.out.println(c + "Modified");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
