package com.infy.ekart.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.product.dto.ProductDTO;
import com.infy.ekart.product.exception.ProductException;
import com.infy.ekart.product.service.ProductService;

@RestController
@RequestMapping(value = "/Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product/{productName}",method=RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductsByName(@PathVariable String productName) throws ProductException{
		
		ProductDTO productFromDB = productService.getProductsByName(productName);
		
		return new ResponseEntity<ProductDTO>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/category/{category}",method=RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) throws ProductException{
		
		List<ProductDTO> productFromDB = productService.getProductsByCategory(category);
		
		return new ResponseEntity<List<ProductDTO>>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getAllProducts()  throws ProductException{
		
		List<ProductDTO> productFromDB = productService.getAllProducts();
		
		return new ResponseEntity<List<ProductDTO>>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/productid/{prodId}",method=RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductsById(@PathVariable Integer prodId) throws ProductException{
		
		ProductDTO productFromDB = productService.getProductById(prodId);
		
		return new ResponseEntity<ProductDTO>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/productadd",method=RequestMethod.POST)
	public ResponseEntity<String> addProductBySeller(@RequestBody ProductDTO product) throws ProductException{
		
		String productServ = productService.addProducts(product);
		
		String sm = productServ + " successfully added";
		
		return new ResponseEntity<>(sm, HttpStatus.OK);

		
	}
	
	@RequestMapping(value="/productdelete/{productName}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProductBySeller(@PathVariable String productName) throws ProductException{
		
		productService.deleteProducts(productName);
		
		String sm = "product successfully deleted";
		
		return new ResponseEntity<>(sm, HttpStatus.OK); 
		
	}
	
	
	
}
