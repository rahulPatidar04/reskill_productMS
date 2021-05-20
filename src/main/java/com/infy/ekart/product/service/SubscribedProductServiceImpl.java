package com.infy.ekart.product.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ekart.product.dto.SubscribedProductDTO;
import com.infy.ekart.product.entity.SubscribedProduct;
import com.infy.ekart.product.exception.ProductException;
import com.infy.ekart.product.repository.SubscribedProductRepository;

@Service(value = "subscribedProductService")
@Transactional
public class SubscribedProductServiceImpl implements SubscribedProductService {

	@Autowired
	private SubscribedProductRepository subscribedProductRepository;
	
	@Override
	public String subscribe(SubscribedProductDTO sp) throws ProductException {
	
		SubscribedProduct subscribeEntity = new SubscribedProduct();
		
		subscribeEntity.setBuyerId(sp.getBuyerId());
		subscribeEntity.setProdId(sp.getProdId());
		subscribeEntity.setQuantity(sp.getQuantity());
		
		subscribedProductRepository.save(subscribeEntity);
		
		return "Product subscribed";
		
	}

	
}
