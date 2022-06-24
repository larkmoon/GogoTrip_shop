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
public class CateVO {
	private int id;
	private String name;
	private Integer upid;
	
	// INSERT(no upid)
	public CateVO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
