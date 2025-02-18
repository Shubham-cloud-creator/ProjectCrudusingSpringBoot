package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existPro = getProductById(id);
		existPro.setName(product.getName());
		existPro.setPrice(product.getPrice());
		existPro.setQuantity(product.getQuantity());
		return productRepository.save(existPro);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}

}
