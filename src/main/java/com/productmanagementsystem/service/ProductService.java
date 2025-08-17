package com.productmanagementsystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productmanagementsystem.dao.ProductDao;
import com.productmanagementsystem.entity.Product;
import com.productmanagementsystem.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product p) {
		dao.add(p);
		ResponseStructure<Product> rs= new ResponseStructure<Product>();
		rs.setData(p);
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setLocldatetime(LocalDateTime.now());
		rs.setMsg("Data Inserted");
		return new ResponseEntity<ResponseStructure<Product>>(rs, HttpStatus.ACCEPTED);
	}
	
	public List<Product> findall(){
		return dao.findAll();
	}
	
	public ResponseEntity<ResponseStructure<Product>> FindById(int id){
		Optional<Product> option= dao.findByID(id);
		if(option.isPresent()) {
			Product p= option.get();
			ResponseStructure<Product> re= new ResponseStructure<>();
			re.setData(p);
			re.setLocldatetime(LocalDateTime.now());
			re.setMsg("Data Found");
			re.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Product>>(re, HttpStatus.FOUND);	
		}else {
			ResponseStructure<Product> re= new ResponseStructure<>();
			re.setLocldatetime(LocalDateTime.now());
			re.setMsg("Data Not Found");
			re.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Product>>(re, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> DeleteByID(int id){
		Optional<Product> option= dao.findByID(id);
		if(option.isPresent()) {
			ResponseStructure<Product> re= new ResponseStructure<>();
			Product p= option.get();
			dao.deleteById(p);
			re.setLocldatetime(LocalDateTime.now());
			re.setMsg("Data Deleted");
			re.setStatusCode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<Product>>(re, HttpStatus.NO_CONTENT);	
		}else {
			ResponseStructure<Product> re= new ResponseStructure<>();
			re.setLocldatetime(LocalDateTime.now());
			re.setMsg("Data Not Found");
			re.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Product>>(re, HttpStatus.NOT_FOUND);
		}
	}
	
	
}
