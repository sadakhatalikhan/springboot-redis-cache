package com.redis.cache.service;

import org.springframework.http.ResponseEntity;

import com.redis.cache.request.ProductRequest;
import com.redis.cache.response.Response;

public interface ProductService {

	ResponseEntity<Response> addProduct(ProductRequest productRequest);
	
	ResponseEntity<Response> getAllProducts();
	
	ResponseEntity<Response> getProductById(Long productId);
	
	ResponseEntity<Response> updateProductDetails(ProductRequest productRequest);
	
	ResponseEntity<Response> deleteproductById(Long productId);

}
