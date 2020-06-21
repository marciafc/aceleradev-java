package br.com.codenation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;

import static org.junit.Assert.*;

public class OrderServiceTest {

	private OrderService orderService = new OrderServiceImpl();

	@Test
	public void testCalculateOrderValue() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		Double total = this.orderService.calculateOrderValue(items);
		assertNotNull(total);
		assertEquals(Double.valueOf(850), total);
	}

	@Test
	public void testCalculateOrderValueWithDiscount() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(6l, 2l));
		items.add(new OrderItem(8l, 1l));
		Double total = this.orderService.calculateOrderValue(items);
		assertNotNull(total);
		assertEquals(Double.valueOf(230.4), total);
	}

	@Test
	public void testFindProductsById() {
		assertNotNull(this.orderService.findProductsById(Arrays.asList(1l, 2l, 3l, 4l, 5l)).size());
	}

	@Test
	public void testCalculateMultipleOrders() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		List<OrderItem> items2 = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		List<OrderItem> items3 = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		assertNotNull(this.orderService.calculateMultipleOrders(Arrays.asList(items, items2, items3)));
	}

	@Test
	public void testGroupProducts() {
		Map<Boolean, List<Product>> groupedProducts = this.orderService.groupProductsBySale(Arrays.asList(1l, 2l, 12l));

		List<Product> productsSaleTrue = groupedProducts.get(true);
		List<Product> productsSaleFalse = groupedProducts.get(false);

		assertNotNull(productsSaleTrue);
		assertNotNull(productsSaleFalse);

		assertEquals(1, productsSaleTrue.size());
		assertEquals(2, productsSaleFalse.size());
	}

}
