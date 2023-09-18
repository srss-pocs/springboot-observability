package com.example.observability.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.observability.entity.Product;
import com.example.observability.repository.ProductRepository;

import io.micrometer.observation.annotation.Observed;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Observed(name = "add.products")
	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	@Observed(name = "get.product")
	public Product getProduct(int id) {
		return productRepository.findById(id).get();
	}

	@Observed(name = "get.products")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product updateProduct(Product productRequest) {
		return productRepository.save(productRequest);
	}

	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "product deleted";
	}

}