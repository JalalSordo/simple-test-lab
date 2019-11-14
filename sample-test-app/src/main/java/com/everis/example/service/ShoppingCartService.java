
package com.everis.example.service;

import java.util.List;

import com.everis.example.model.Item;

public interface ShoppingCartService {

	public void cleanUpCart();

	public void addItem(Item a);

	public int getNbrOfItems();

	public List<Item> getItems();

	public Double totalPrice();

	public Double calculateDiscount(Double price, Double percentageDiscount);

}
