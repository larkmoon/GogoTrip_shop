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
	private int id;
	private String uid;
	private int pid;
	private int cnt;
	private Date regdate;
	private String cname;
	private String pname;
	private int price;
	private int sprice; // ct.cnt * p.price AS sprice
	private String imgname;
	private int stock;
	private int point;
	private int totalpoint;
	private int totalprice;
	private double discount;
	private int saleprice;
	private int discountedprice;
	
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
	
	public void initsale() {
		this.saleprice = (int) (this.price * (1 - this.discount));
		this.totalprice = this.saleprice * this.cnt;
		this.point = (int) (Math.floor(this.saleprice*0.05));
		this.totalpoint = this.point * this.cnt;
		this.discountedprice = (this.price * this.cnt) - this.totalprice;
	}
	
	
	// saleprice = 가격 * (1 - 할인율)
	// 원가: price * cnt
	// 할인액 : (price * cnt) - saleprice
	
	
	
	
}
