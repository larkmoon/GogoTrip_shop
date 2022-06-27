package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BuypageItemVO {
	private int pid;
	private int cnt;
	private String uid;
	private String name;
	private int price;
	public int sprice;
	public String imgname;
	private double discount;
	private int saleprice;
	private int totalprice;
	private int point;
	private int totalpoint;
	private int discountedprice;
	
	
	
	
	public void initsale() {
		this.saleprice = (int) (this.price * (1 - this.discount));
		this.sprice = this.price * this.cnt;
		this.totalprice = this.saleprice * this.cnt;
		this.point = (int) (Math.floor(this.saleprice*0.05));
		this.totalpoint = this.point * this.cnt;
		this.discountedprice = (this.price * this.cnt) - this.totalprice;
	}

	public BuypageItemVO(int pid, int cnt, String uid) {
		super();
		this.pid = pid;
		this.cnt = cnt;
		this.uid = uid;
	}
	
	

	public BuypageItemVO(int pid, int cnt, String uid, String name, int price, String imgname,
			double discount) {
		super();
		this.pid = pid;
		this.cnt = cnt;
		this.uid = uid;
		this.name = name;
		this.price = price;
		this.imgname = imgname;
		this.discount = discount;
	}

	public BuypageItemVO(int pid, int cnt) {
		super();
		this.pid = pid;
		this.cnt = cnt;
	}

	public BuypageItemVO(int pid, String name, int price, String imgname, double discount) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.imgname = imgname;
		this.discount = discount;
	}

	
	
	
}
