package com.redis.cache.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.cache.request.ProductRequest;
import com.redis.cache.response.Response;
import com.redis.cache.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	// add products
	@PostMapping("/add")
	public ResponseEntity<Response> addProduct(ProductRequest productRequest) {
		return productService.addProduct(productRequest);
	}
	
	// getAll Products
	@GetMapping("/get")
	public ResponseEntity<Response> getAllProducts() {
		return productService.getAllProducts();
	}
	
	// get product by id
	@GetMapping("/get/{productId}")
	public ResponseEntity<Response> getProduct(@PathVariable Long productId) {
		return productService.getProductById(productId);
	}
	
	// update product
	@PutMapping("/update")
	public ResponseEntity<Response> updateProduct(ProductRequest productRequest) {
		return productService.updateProductDetails(productRequest);
	}
	
	// delete product
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteProduct(@PathVariable Long productId) {
		return productService.deleteproductById(productId);
	}
}
