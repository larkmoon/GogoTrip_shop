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
	private int id;
	private int oid;
	private int pid;
	private int cnt;
	private String delivery;
	
	private String uid;
	private String uname;
	private String totalprice;
	
	
	private String pname;
	private int pprice;
	
	// for insert
	public BuydetailVO(int oid, int pid, int cnt) {
		this.oid = oid;
		this.pid = pid;
		this.cnt = cnt;
	}
	public BuydetailVO(int id, int oid, int pid, int cnt) {
		this.id = id;
		this.oid = oid;
		this.pid = pid;
		this.cnt = cnt;
	}
	

}
