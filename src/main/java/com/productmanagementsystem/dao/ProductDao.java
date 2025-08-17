package com.productmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

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
	
	public List<Product> findAll() {
		return jpa.findAll();
	}
	
	public Optional<Product> findByID(int id){
		return jpa.findById(id);
	}
	
	public void deleteById(Product p) {
		 jpa.delete(p);
	}
}
	