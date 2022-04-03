package com.redis.cache.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class ProductRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7141256215284164968L;
	private String productName;
	private String productPrice;

}
