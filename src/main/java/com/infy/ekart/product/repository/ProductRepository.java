package com.infy.ekart.product.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infy.ekart.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product , Integer>{
	
	//@Query("select * from products p where p.product_name=?1")
	public Product findByProductName(String productName);
	
	public List<Product> findByCategory(String category);
	
	public Product findByProdId(Integer prodId);
	
	
	
	
	
		
}
