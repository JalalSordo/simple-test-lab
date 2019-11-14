package com.everis.example.service;

import java.util.ArrayList;
import java.util.List;

import com.everis.example.model.Item;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	public ShoppingCartServiceImpl() {
		listOfItems = new ArrayList<Item>();
	}

	private List<Item> listOfItems;

	public void cleanUpCart() {
			listOfItems.clear();
	}

	public void addItem(Item anItem) {
		listOfItems.add(anItem);
	}

	public int getNbrOfItems() {
		return listOfItems.size();
	}

	public List<Item> getItems() {
		return listOfItems;
	}

	public Double totalPrice() {
		return listOfItems.stream().mapToDouble(Item::getPrice).sum();
	}

	public Double calculateDiscount(Double price, Double percentageDiscount) {
		return price*percentageDiscount;
	}

}
