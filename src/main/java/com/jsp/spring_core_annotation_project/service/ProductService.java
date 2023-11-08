package com.jsp.spring_core_annotation_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spring_core_annotation_project.dao.ProductDao;
import com.jsp.spring_core_annotation_project.dto.Product;

@Service(value ="service")
public class ProductService {
	
	@Autowired
	ProductDao dao;

	
	public Product saveProductService(Product product) {
	
		return  dao.saveProductDao(product);
	}
	
//	getById method for display only one row
	  public Product getByIdProductService(int productId) {
	  
	  return dao.getByIdProductDao(productId); }
	 

//    delete method of the product
    public Product deleteGetByIdProductService(int productId) {
    	return dao.deleteGetByIdProductDao(productId);
    }
	  
//  update method of the product
  public Product  updateGetByIdProductService(int productId,String productName) {
	  return dao.updateGetByIdProductDao(productId, productName);
  }
  
//display method service
  public List<Product> displayAllProductService() {
	  
	  return dao.displayAllProductDao();
  }
}
