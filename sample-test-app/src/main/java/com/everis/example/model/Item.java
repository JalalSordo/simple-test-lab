package com.everis.example.model;

import lombok.Getter;
import lombok.Setter;

public class Item {

	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private Double price;

	public Item(String name, Double price) {
		this.name = name;
		this.price = price;
	}

}
