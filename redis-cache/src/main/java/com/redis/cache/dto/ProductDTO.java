package com.redis.cache.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class ProductDTO {

	private Long id;
	private String productName;
	private String productPrice;
	@JsonFormat(pattern = "DD-MM-YYYY HH24:MI:SS")
	private Date createDate;
	@JsonFormat(pattern = "DD-MM-YYYY HH24:MI:SS")
	private Date modifyDate;
	
}
