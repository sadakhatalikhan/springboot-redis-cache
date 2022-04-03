package com.redis.cache.helper;

import org.springframework.stereotype.Component;

import com.redis.cache.dto.ProductDTO;
import com.redis.cache.model.Product;
import com.redis.cache.request.ProductRequest;

@Component
public class ProductHelper {
	public ProductDTO dtoMapper(Product product) {
		return ProductDTO.builder().id(product.getId()).productName(product.getProductName())
				.productPrice(product.getProductPrice()).createDate(product.getCreateDate())
				.modifyDate(product.getModifyDate()).build();
	}

	public Product modelMapper(ProductRequest product) {
		return Product.builder().productName(product.getProductName()).productPrice(product.getProductPrice()).build();
	}
}
