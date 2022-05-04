package com.mycompany.myapp.vo;

import java.sql.Date;

public class PurchaseVO {
	private int purchaseNo;
	private int purchaseUserId;
	private int purchaseItemNo;
	private Date purchaseDate;
	public PurchaseVO() {
		super();
	}
	public int getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public int getPurchaseUserId() {
		return purchaseUserId;
	}
	public void setPurchaseUserId(int purchaseUserId) {
		this.purchaseUserId = purchaseUserId;
	}
	public int getPurchaseItemNo() {
		return purchaseItemNo;
	}
	public void setPurchaseItemNo(int purchaseItemNo) {
		this.purchaseItemNo = purchaseItemNo;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "PurchaseVO [purchaseNo=" + purchaseNo + ", purchaseUserId=" + purchaseUserId + ", purchaseItemNo="
				+ purchaseItemNo + ", purchaseDate=" + purchaseDate + "]";
	}
	
}
