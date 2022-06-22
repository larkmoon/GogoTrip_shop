package com.multi.commu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.CommuVO;

@SpringBootTest
class CommuSelectByKeywordTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		CommuVO obj = new CommuVO();
		obj.setFrom("writer");
		obj.setKeyword("문설연");
		try {
			List<CommuVO> searchlist = biz.getbykeyword(obj);
			for (CommuVO c : searchlist) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
