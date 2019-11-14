package com.everis.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.everis.example.model.Item;

public class ShoppingCartTest {

	private ShoppingCartService shoppingCart;

	@BeforeClass
	public static void setUpTestClass() {
		System.out.println("---------->Setting Up the test Class");
	}

	@AfterClass
	public static void cleanUpTestClass() {
		System.out.println("---------->Clean Up the test Class");
	}

	@Before
	public void setUpTest() {
		System.out.println("---->Setting Up the test");
		shoppingCart = new ShoppingCartServiceImpl();
		Item item1 = new Item("Item1", 200.0d);
		shoppingCart.addItem(item1);
	}

	@After
	public void cleanUpTest() {
		System.out.println("---->Clean Up the test");
		if (null != shoppingCart) {
			shoppingCart.cleanUpCart();
		}

	}

	@Test
	public void testCleanUpCart() {
		System.out.println("-->Executing testCleanUpCart()");
		shoppingCart.cleanUpCart();
		assertEquals(0, shoppingCart.getItems().size());

	}

	@Test
	public void testAddItem() {
		System.out.println("-->Executing testAddItem()");
		assertEquals(1, shoppingCart.getItems().size());
		Item item2 = new Item("Item2", 200.0d);
		shoppingCart.addItem(item2);
		assertEquals("Item2", shoppingCart.getItems().get(1).getName());
	}

	@Test
	public void testGetNbrOfItems() {
		System.out.println("-->Executing testGetNbrOfItems()");
		Item item2 = new Item("Item2", 200.0d);

		shoppingCart.addItem(item2);

		assertEquals(2, shoppingCart.getNbrOfItems());
	}

	@Test
	public void testGetItems() {
		System.out.println("-->Executing testGetItems()");
		Item item2 = new Item("Item2", 150.0d);

		shoppingCart.addItem(item2);

		assertNotNull(shoppingCart.getItems());
	}

	@Test
	public void testTotalPrice() {
		System.out.println("-->Executing testTotalPrice()");
		Item item2 = new Item("Item1", 200.0d);
		Item item3 = new Item("Item2", 300.0d);
		Item item4 = new Item("Item3", 400.0d);

		shoppingCart.addItem(item2);
		shoppingCart.addItem(item3);
		shoppingCart.addItem(item4);

		assertEquals(new Double(1100.0), shoppingCart.totalPrice());
	}

	@Test
	public void testCalculateDiscount() {
		System.out.println("-->Executing testCalculateDiscount()");
		assertEquals(new Double(0.0), shoppingCart.calculateDiscount(0.0d, 0.2d));
		assertEquals(new Double(0.0), shoppingCart.calculateDiscount(100.0d, 0.0d));
		assertEquals(new Double(20.0), shoppingCart.calculateDiscount(100.0d, 0.2d));
	}

}
