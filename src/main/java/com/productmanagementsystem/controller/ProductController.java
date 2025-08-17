package com.productmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagementsystem.entity.Product;
import com.productmanagementsystem.service.ProductService;
import com.productmanagementsystem.util.ResponseStructure;

@RestController
/*
 * creating REST API
 */
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping("/AddProduct")
	public ResponseEntity<ResponseStructure<Product>> createProduct(Product p) {
		return service.addProduct(p);
	}
	@GetMapping("FindAll")
	public List<Product> findAll(){
		return service.findall();
	}
	
	@GetMapping("/FindByID")
	public ResponseEntity<ResponseStructure<Product>> findById(@RequestParam int id){
		return service.FindById(id);
	}
	
	@GetMapping("/DeleteById")
	public ResponseEntity<ResponseStructure<Product>> DeleteById(@RequestParam int id){
		return service.DeleteByID(id);
	}
	
}
