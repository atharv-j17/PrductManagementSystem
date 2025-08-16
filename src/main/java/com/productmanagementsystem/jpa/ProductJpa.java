package com.productmanagementsystem.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productmanagementsystem.entity.Product;

public interface ProductJpa extends JpaRepository<Product, Integer> {

}
