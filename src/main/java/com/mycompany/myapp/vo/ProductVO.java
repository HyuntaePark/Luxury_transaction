package com.mycompany.myapp.vo;

public class ProductVO {
	private int productNo;
	private int productCategoryNo;
	private String sallerUserId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int productSaleStatusId;
	
	@Override
	public String toString() {
		return "ProductVO [productNo=" + productNo + ", productCategoryNo=" + productCategoryNo + ", sallerUserId="
				+ sallerUserId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + ", productSaleStatusId=" + productSaleStatusId + "]";
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getProductCategoryNo() {
		return productCategoryNo;
	}

	public void setProductCategoryNo(int productCategoryNo) {
		this.productCategoryNo = productCategoryNo;
	}

	public String getSallerUserId() {
		return sallerUserId;
	}

	public void setSallerUserId(String sallerUserId) {
		this.sallerUserId = sallerUserId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductSaleStatusId() {
		return productSaleStatusId;
	}

	public void setProductSaleStatusId(int productSaleStatusId) {
		this.productSaleStatusId = productSaleStatusId;
	}

	public ProductVO() {
		super();
	}

	
	
}
