package com.infy.ekart.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.ekart.product.dto.ProductDTO;
import com.infy.ekart.product.entity.Product;
import com.infy.ekart.product.exception.ProductException;
import com.infy.ekart.product.repository.ProductRepository;


@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	Environment env;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO getProductsByName(String productName) throws ProductException{
		
		Product productFromDB = productRepository.findByProductName(productName);
		
		if(productFromDB==null) {
			
	       throw new ProductException("Product Does Not Exist");
		}
		
		
		
			ProductDTO dtopro = new ProductDTO();
			dtopro.setProdId(productFromDB.getProdId());
			dtopro.setProductName(productFromDB.getProductName());
			dtopro.setPrice(productFromDB.getPrice());
			dtopro.setStock(productFromDB.getStock());
			dtopro.setDescription(productFromDB.getDescription());
			dtopro.setSellerId(productFromDB.getSellerId());
			dtopro.setCategory(productFromDB.getCategory());
			dtopro.setSubCategory(productFromDB.getSubCategory());
			dtopro.setProductRating(productFromDB.getProductRating());
			
			
		

		
		return dtopro;
	}

	@Override
	public List<ProductDTO> getProductsByCategory(String category) throws ProductException {

		List<Product> productFromDB = productRepository.findByCategory(category);
		
		if(productFromDB.isEmpty()) {
			throw new ProductException("No product of this name present");
		}
		
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		for(Product pd : productFromDB) {
			ProductDTO prodto = new ProductDTO();
			prodto.setProdId(pd.getProdId());
			prodto.setProductName(pd.getProductName());
			prodto.setPrice(pd.getPrice());
			prodto.setStock(pd.getStock());
			prodto.setDescription(pd.getDescription());
			prodto.setSellerId(pd.getSellerId());
			prodto.setCategory(pd.getCategory());
			prodto.setSubCategory(pd.getSubCategory());
			prodto.setProductRating(pd.getProductRating());
			
			productDTOList.add(prodto);
		}
		

		
		return productDTOList;
	}

	@Override
	public List<ProductDTO> getAllProducts() throws ProductException {
		
List<Product> productFromDB = (List<Product>) productRepository.findAll();
		
		if(productFromDB.isEmpty()) {
			throw new ProductException("No product of this name present");
		}
		
		List<ProductDTO> prodDTOList = new ArrayList<ProductDTO>();
		for(Product pd : productFromDB) {
			ProductDTO pdto = new ProductDTO();
			pdto.setProdId(pd.getProdId());
			pdto.setProductName(pd.getProductName());
			pdto.setPrice(pd.getPrice());
			pdto.setStock(pd.getStock());
			pdto.setDescription(pd.getDescription());
			pdto.setSellerId(pd.getSellerId());
			pdto.setCategory(pd.getCategory());
			pdto.setSubCategory(pd.getSubCategory());
			pdto.setProductRating(pd.getProductRating());
			
			prodDTOList.add(pdto);
		}
		

		
		return prodDTOList;
	}

	@Override
	public ProductDTO getProductById(Integer prodId) throws ProductException {
		Product pd = productRepository.findByProdId(prodId);
		
		if(pd==null) {
			
		throw new ProductException("Service.Product_Absent");
		}
		
			ProductDTO dto = new ProductDTO();
			dto.setProdId(pd.getProdId());
			dto.setProductName(pd.getProductName());
			dto.setPrice(pd.getPrice());
			dto.setStock(pd.getStock());
			dto.setDescription(pd.getDescription());
			dto.setSellerId(pd.getSellerId());
			dto.setCategory(pd.getCategory());
			dto.setSubCategory(pd.getSubCategory());
			dto.setProductRating(pd.getProductRating());
			
		

		
		return dto;
	}
	
	@Override
	public String addProducts(ProductDTO productDTO) throws ProductException{
		
		if(productRepository.findByProductName(productDTO.getProductName()) !=null)
			throw new ProductException("Buyer Already Exists");
		
		Product productEntity = new Product();
		productEntity.setProdId(productDTO.getProdId());
		productEntity.setProductName(productDTO.getProductName());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setStock(productDTO.getStock());
		productEntity.setDescription(productDTO.getDescription());
		productEntity.setSellerId(productDTO.getSellerId());
		productEntity.setCategory(productDTO.getCategory());
		productEntity.setSubCategory(productDTO.getSubCategory());
		productEntity.setProductRating(productDTO.getProductRating());
		
		productRepository.save(productEntity);
		
		return productEntity.getProductName();
		
	}
	
	@Override
	public void deleteProducts(String productName) throws ProductException{
		
		Product product = productRepository.findByProductName(productName);
		
		if(product == null) 
			throw new ProductException("Buyer Not Present");
		
		productRepository.delete(product);
		
	}
	
}
