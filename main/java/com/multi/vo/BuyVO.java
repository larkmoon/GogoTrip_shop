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
public class BuyVO {
	public int id;
	public String uid;
	public String name;
	public int zip;
	public String addrf;
	public String addrs;
	public String phone;
	public String orderstate;
	public int deliveryfee;
	public int usedpoint;
	public int totalprice;
	public String payment;
	public Date regdate;

	// for insert
	public BuyVO(String uid, String name, int zip, String addrf, String addrs, String phone, int totalprice,
			String payment) {
		this.uid = uid;
		this.name = name;
		this.zip = zip;
		this.addrf = addrf;
		this.addrs = addrs;
		this.phone = phone;
		this.totalprice = totalprice;
		this.payment = payment;
	}

	// for update
	public BuyVO(int id, String uid, String name, int zip, String addrf, String addrs, String phone, int totalprice,
			String payment) {
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.zip = zip;
		this.addrf = addrf;
		this.addrs = addrs;
		this.phone = phone;
		this.totalprice = totalprice;
		this.payment = payment;
	}
	
	
	
	
}
