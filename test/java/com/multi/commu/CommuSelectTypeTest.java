package com.multi.commu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.TypeVO;

@SpringBootTest
class CommuSelectTypeTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		try {
			List<TypeVO> list = biz.gettype();
			for (TypeVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
