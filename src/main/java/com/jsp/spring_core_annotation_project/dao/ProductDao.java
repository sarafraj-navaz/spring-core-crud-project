package com.jsp.spring_core_annotation_project.dao;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jsp.spring_core_annotation_project.dto.Product;

@Repository
public class ProductDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Product saveProductDao(Product product) {

		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();

		return product;
	}

	/* getByProduct Dao display method */

	public Product getByIdProductDao(int productId) {
		return entityManager.find(Product.class, productId);
	}
	
//    delete method of the product
    public Product deleteGetByIdProductDao(int productId) {
    	Product  product= getByIdProductDao(productId);
        
    	entityTransaction.begin();
    	entityManager.remove(product);
    	entityTransaction.commit();
    	
    	return product;
    }
    
//    update method of the product
    public Product  updateGetByIdProductDao(int productId,String productName) {
    	Product  product1  = getByIdProductDao(productId);
    	
        if(product1 != null) {
        	product1.setProductName(productName);
        	entityTransaction.begin();
        	entityManager.merge(product1);
        	entityTransaction.commit();
        	
        	return product1;
        }
    
		return null;
    	
    }
    
//display method dao
    public List<Product> displayAllProductDao() {
    	
    	String display =" from Product";
    	Query query = entityManager.createQuery(display);
    	
    	return query.getResultList();
    	
    }
}
