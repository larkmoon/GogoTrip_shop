package com.multi.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BuypageVO {
	private List<BuypageItemVO> orders;

	public void setOrders(List<BuypageItemVO> orders) {
		this.orders = orders;
	}

		
	
}

