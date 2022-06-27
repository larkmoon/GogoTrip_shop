package com.multi.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

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
public class ProductVO {
	private int id;
	private String name;
	private int price;
	private int cid;
	private int upid;
	private String catename;
	private Date regdate;
	private int stock;
	private double discount;
	private String imgname;
	private String description;
	private MultipartFile mf;
	
	// INSERT
	public ProductVO(String name, int price, int cid, int stock, String imgname, String description) {
		super();
		this.name = name;
		this.price = price;
		this.cid = cid;
		this.stock = stock;
		this.imgname = imgname;
		this.description = description;
	}
	
	// UPDATE
	public ProductVO(int id, String name, int price, int cid, int stock, String imgname,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cid = cid;
		this.stock = stock;
		this.imgname = imgname;
		this.description = description;
	}
	
	
	
	
}
