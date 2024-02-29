package com.pedro.demo.services;

import java.util.List;

import com.pedro.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedro.demo.dto.ProductDTO;
import com.pedro.demo.entities.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product entity = productRepository.findById(id).get();
		return new ProductDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		return productRepository.findAll().stream().map(x -> new ProductDTO(x)).toList();
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity = productRepository.save(entity);
		return new ProductDTO(entity);
	}
}
