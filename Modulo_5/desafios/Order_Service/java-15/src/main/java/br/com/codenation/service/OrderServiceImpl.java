package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

import static java.util.stream.Collectors.groupingBy;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	public static final double PERCENT_DISCOUNT = 0.2;

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().
				mapToDouble(orderItem -> {

					Product product = productRepository.findById(orderItem.getProductId())
							.orElseGet(null);

					if(product != null) {
						Double grossAmount = product.getValue() * orderItem.getQuantity();
						return product.getIsSale() ? grossAmount * (1 - PERCENT_DISCOUNT) : grossAmount;
					}
					return 0;
				}).sum();
			//.reduce((left, right) -> left + right).getAsDouble();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.map(id ->  productRepository.findById(id)
						.orElse(null))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
				.mapToDouble(this::calculateOrderValue).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {

		List<Product> products = productRepository.findAll().stream()
				.filter(p -> productIds.contains(p.getId())).
				collect(Collectors.toList());

		Map<Boolean, List<Product>> productsBySaleMap = products.stream()
				.collect(groupingBy(Product::getIsSale));

		return productsBySaleMap;
	}

}