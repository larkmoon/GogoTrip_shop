package com.multi.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

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
public class CommuVO {
	private int id;
	private String uid;
	private String uname;
	private String type;
	private String title;
	private String content;
	private Date regdate;
	private String location;
	private String imgname;
	private int views;
	private MultipartFile mf;
	private String from;
	private String keyword;
	
	// INSERT
	public CommuVO(String uid, String type, String title, String content, String location, String imgname, MultipartFile mf) {
		super();
		this.uid = uid;
		this.type = type;
		this.title = title;
		this.content = content;
		this.location = location;
		this.imgname = imgname;
		this.mf = mf;
	}
	
	// UPDATE
	public CommuVO(int id, String type, String title, String content, String location, String imgname, MultipartFile mf) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.content = content;
		this.location = location;
		this.imgname = imgname;
		this.mf = mf;
	}

	public CommuVO(int id, String uid, String uname, String type, String title, String content, Date regdate,
			String location, String imgname, int views) {
		super();
		this.id = id;
		this.uid = uid;
		this.uname = uname;
		this.type = type;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.location = location;
		this.imgname = imgname;
		this.views = views;
	}

	public CommuVO(int id, int views) {
		super();
		this.id = id;
		this.views = views;
	}
	
	
	
	

	
	
	
	
}
