package com.productmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productmanagementsystem.entity.Product;
import com.productmanagementsystem.jpa.ProductJpa;

@Repository
public class ProductDao {

	@Autowired
	ProductJpa jpa;
	
	public Product add(Product p) {
		return jpa.save(p);
	}
	
}
	