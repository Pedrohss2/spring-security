package com.pedro.demo.dto;

import com.pedro.demo.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Long id;
	private String name;

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
	}

}
