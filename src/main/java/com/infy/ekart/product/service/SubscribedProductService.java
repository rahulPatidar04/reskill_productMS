package com.infy.ekart.product.service;

import com.infy.ekart.product.dto.SubscribedProductDTO;
import com.infy.ekart.product.exception.ProductException;

public interface SubscribedProductService {

	public String subscribe(SubscribedProductDTO sp) throws ProductException;
	
}
