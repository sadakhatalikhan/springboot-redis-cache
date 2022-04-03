package com.redis.cache.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis.cache.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Optional<Product> findByProductName(String productName);
	
}
