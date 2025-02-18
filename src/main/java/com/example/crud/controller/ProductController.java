package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Product;
import com.example.crud.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(consumes = {"application/xml", "application/json"}, produces = {"application/xml", "application/json"})
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>  deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
		return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.OK);
	}
}  
