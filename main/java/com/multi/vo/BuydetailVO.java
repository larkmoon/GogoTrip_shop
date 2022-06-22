package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BuydetailVO {
	public int id;
	public int oid;
	public int pid;
	public int cnt;
	// for insert
	public BuydetailVO(int oid, int pid, int cnt) {
		this.oid = oid;
		this.pid = pid;
		this.cnt = cnt;
	}
	

}
