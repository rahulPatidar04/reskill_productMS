package com.infy.ekart.product.service;

import java.util.List;

import com.infy.ekart.product.dto.ProductDTO;
import com.infy.ekart.product.exception.ProductException;

public interface ProductService {

	public ProductDTO getProductsByName(String productName) throws ProductException ;
	
	public List<ProductDTO> getProductsByCategory(String category) throws ProductException ;
	
	public List<ProductDTO> getAllProducts() throws ProductException ;
	
	public ProductDTO getProductById(Integer prodId) throws ProductException ;
	
	public String addProducts(ProductDTO productDTO) throws ProductException;
	
	public void deleteProducts(String productName) throws ProductException;
		
}
