package com.multi.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private Date regdate;
	private int point;
	private int zip;
	private String addrf;
	private String addrs;
	
	// INSERT
	public CustVO(String id, String pwd, String name, String email, String phone, int zip, String addrf, String addrs) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zip = zip;
		this.addrf = addrf;
		this.addrs = addrs;
	}
	
	// UPDATE(순서 주의! id가 가장 뒤)
	public CustVO(String pwd, String name, String email, String phone, int zip, String addrf, String addrs, String id) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zip = zip;
		this.addrf = addrf;
		this.addrs = addrs;
	}

	// UPDATE POINT
	public CustVO(String id, int point) {
		super();
		this.id = id;
		this.point = point;
	}
	
	
	
	
	
}


