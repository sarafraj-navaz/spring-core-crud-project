package com.jsp.spring_core_annotation_project.controller;



import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring_core_annotation_project.configuration.ProductConfiguration;
import com.jsp.spring_core_annotation_project.dto.Product;
import com.jsp.spring_core_annotation_project.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		
	  ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(ProductConfiguration.class);
	  Product product= (Product) applicationContext.getBean("product");
	  
	

	  ProductService service  = (ProductService) applicationContext.getBean("service");
		
	  
	  Scanner sc = new Scanner(System.in);
		
	  while (true) {
		System.out.println("1.insert \n2.getById\n3.update\n4.delete\n5.display\n6.ByTostring");
		System.out.println("enter the option");
		int choice =sc.nextInt();
		
		switch (choice) {
		case 1:{
			  product.setProductId(10);
			  product.setProductName("sakshi");
			  product.setProductEmail("s@gmail.com");
			  product.setProductNumber(761780);
			  
			  service.saveProductService(product);
		}break;
		case 2:{
			System.out.println("enter  the ProductId");
			int productId =sc.nextInt();
			 Product product1= service.getByIdProductService(productId);
			if (product1 != null) {
				
				System.out.print(product1.getProductId()+"\t\t\t");
				System.out.print(product1.getProductName()+"\t\t\t");
				System.out.print(product1.getProductEmail()+"\t\t");
				System.out.print(product1.getProductName()+"\t\t");
				
				System.out.println(" ");
			} else {
				System.out.println("please check your given ProductId");
				
			}
		}break;
		case 3:{
			System.out.println("enter the ProductId");
			int  productId =sc.nextInt();
			
			System.out.println("enter the ProductName");
			String name =sc.next();
			

			Product  product1= service.updateGetByIdProductService(productId, name);
			if(product1 != null) {
				System.err.println("table has been update");
			}
			else {
				System.out.println("please check your productId");
			}
		}break;
		case 4:{
			 System.out.println("enter the productId");
			 int  productId =sc.nextInt();
			 
			 Product product1= service.deleteGetByIdProductService(productId);
			 
			 if(product1 != null) {
				 System.out.println("productId has been deleted");
			 }
			 else {
				 System.out.println("please check your ProductId");
			 }
		}break;
		case 5:{
			System.err.println("display");
			List<Product> product1 =service.displayAllProductService();
			
			for (Product products : product1) {
				System.out.println(products);
				System.out.print(products.getProductId()+"\t\t\t");
				System.out.print(products.getProductName()+"\t\t\t");
				System.out.print(products.getProductEmail()+"\t\t");
				System.out.print(products.getProductName()+"\t\t");
				
				System.out.println(" ");
			}
		}break;
		case 6:{
			System.out.println("By using to String method");
			
			List<Product> products = service.displayAllProductService();
			for (Product product2 : products) {
				System.out.println(product2);
			}
		}
		default:
			break;
		}
	}

	}

}
