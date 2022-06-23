package com.multi.vo;

import java.util.Date;

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
public class CartVO {
	public int id;
	public String uid;
	public int pid;
	public int cnt;
	public Date regdate;
	public String cname;
	public String pname;
	public int price;
	public String imgname;
	public int stock;
	
	// for insert
	public CartVO(String uid, int pid, int cnt) {
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
	}

	
	// for update
	public CartVO(int id, String uid, int pid, int cnt) {
		this.id = id;
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
	}

	//for Update Cnt
	public CartVO(int id, int cnt) {
		super();
		this.id = id;
		this.cnt = cnt;
	}
	
	
	
	
	
	
	
}
