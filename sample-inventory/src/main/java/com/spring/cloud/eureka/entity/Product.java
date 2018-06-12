package com.spring.cloud.eureka.entity;


/**
 * @author saikatkar1
 *
 */
public class Product {
    private String productId;
    private String productName;
    private String productType;
    private String price;
    
	public Product(String productId, String productName, String productType, String price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
    
	
	
    
}
