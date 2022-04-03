package com.redis.cache.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.redis.cache.dto.ProductDTO;
import com.redis.cache.exception.ProductExistsException;
import com.redis.cache.exception.ProductNotExistsException;
import com.redis.cache.helper.ProductHelper;
import com.redis.cache.model.Product;
import com.redis.cache.repository.ProductRepository;
import com.redis.cache.request.ProductRequest;
import com.redis.cache.response.Response;
import com.redis.cache.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductHelper productHelper;

	@Override
	@Cacheable(value = "Product", key = "#id")
	public ResponseEntity<Response> addProduct(ProductRequest productRequest) {
		ProductDTO productDTO = new ProductDTO();
		Optional<Product> productOpt = productRepository.findByProductName(productRequest.getProductName());
		if (productOpt.isPresent()) {
			throw new ProductExistsException(999, "Product already registered");
		} else {
			productDTO = productHelper.dtoMapper(productRepository.save(productHelper.modelMapper(productRequest)));
		}
		return ResponseEntity.ok().body(Response.builder().code(0).message("Saved").body(productDTO).build());
	}

	@Override
	@Cacheable(value = "Product", key = "#id")
	public ResponseEntity<Response> getAllProducts() {
		return ResponseEntity.ok()
				.body(Response
						.builder().code(0).message("Products List").body(productRepository.findAll().stream()
								.map(product -> productHelper.dtoMapper(product)).collect(Collectors.toList()))
						.build());
	}

	@Override
	@Cacheable(value = "Product", key = "#id")
	public ResponseEntity<Response> getProductById(Long productId) {

		ProductDTO pDTO = productRepository.findById(productId).map(product -> productHelper.dtoMapper(product))
				.orElseThrow(() -> new ProductNotExistsException(999, "Product Not available"));

		return ResponseEntity.ok().body(Response.builder().code(0).message("Product Details").body(pDTO).build());
	}

	@Override
	@CachePut(value = "Product", key = "#id")
	public ResponseEntity<Response> updateProductDetails(ProductRequest productRequest) {

		ProductDTO pDTO = productRepository.findByProductName(productRequest.getProductName())
				.map(product -> {
						product.setProductPrice(productRequest.getProductPrice());
						return productHelper.dtoMapper(productRepository.save(product));
				}).orElseThrow(() -> new ProductNotExistsException(999, "Product Not available"));

		return ResponseEntity.ok()
				.body(Response.builder().code(0).message("Product Details updated").body(pDTO).build());
	}

	@Override
	@CacheEvict(value = "Product", key = "#id")
	public ResponseEntity<Response> deleteproductById(Long productId) {
		productRepository.deleteById(productId);
		
		return ResponseEntity.ok()
				.body(Response.builder().code(0).message("Product deleted").build());
		
	}

}
