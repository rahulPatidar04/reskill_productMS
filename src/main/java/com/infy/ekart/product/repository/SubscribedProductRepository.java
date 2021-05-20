package com.infy.ekart.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.ekart.product.entity.SubscribedProduct;
import com.infy.ekart.product.entity.SubscribedProductId;

public interface SubscribedProductRepository extends CrudRepository<SubscribedProduct , SubscribedProductId>{

	
	
}
