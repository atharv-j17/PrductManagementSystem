package com.productmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagementsystem.entity.Product;
import com.productmanagementsystem.service.ProductService;
import com.productmanagementsystem.util.ResponseStructure;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping("/AddProduct")
	public ResponseEntity<ResponseStructure<Product>> createProduct(Product p) {
		return service.addProduct(p);
	}
}
