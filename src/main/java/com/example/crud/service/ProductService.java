package com.example.crud.service;

import java.util.List;

import com.example.crud.model.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product createProduct(Product product);

	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);

}
