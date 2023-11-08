package com.jsp.spring_core_annotation_project.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component(value ="product")
@Entity
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private String productEmail;
	private long productNumber;
	


	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductEmail() {
		return productEmail;
	}
	public long getProductNumber() {
		return productNumber;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductEmail(String productEmail) {
		this.productEmail = productEmail;
	}
	public void setProductNumber(long productNumber) {
		this.productNumber = productNumber;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productEmail=" + productEmail
				+ ", productNumber=" + productNumber + "]";
	}
	
	

}
