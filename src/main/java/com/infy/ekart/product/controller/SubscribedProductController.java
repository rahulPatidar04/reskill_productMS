package com.infy.ekart.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.product.dto.BuyerDTO;
import com.infy.ekart.product.dto.SubscribedProductDTO;
import com.infy.ekart.product.exception.ProductException;
import com.infy.ekart.product.service.SubscribedProductService;

@RestController
@RequestMapping(value = "/Subscribe")
public class SubscribedProductController {

	@Autowired
	private SubscribedProductService subscribedProductService;
	
	@RequestMapping(value="/addSubscribe",method=RequestMethod.POST)
	public ResponseEntity<String> addSubProduct(@RequestBody SubscribedProductDTO subscription) throws ProductException{
		
		RestTemplate restTemplate = new RestTemplate();
		String subServ = subscribedProductService.subscribe(subscription);
		String sm = "";
		
		BuyerDTO buyerDTO = restTemplate.getForObject("http://localhost:8000/Buyer/findBuyerById/"+subscription.getBuyerId(), BuyerDTO.class);
		
		if(buyerDTO!=null && buyerDTO.getIsPrivileged()==true) {
			sm = subServ  + "successfully";
		}
		else {
			throw new ProductException("Buyer has no no privilege access");
		}
		
		return new ResponseEntity<>(sm, HttpStatus.OK);

	}
	
}
