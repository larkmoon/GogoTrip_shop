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
public class MarkerVO {
	private int id;
	private int bid;
	private String name;
	private double lat;
	private double longt;
	
	// INSERT
	public MarkerVO(int bid, String name, double lat, double longt) {
		super();
		this.bid = bid;
		this.name = name;
		this.lat = lat;
		this.longt = longt;
	}

	// UPDATE 순서 주의! id가 가장 뒤에 옴
	public MarkerVO(String name, double lat, double longt, int id) {
		super();		
		this.name = name;
		this.lat = lat;
		this.longt = longt;
		this.id = id;
	}

	
		
	
	
	

}
