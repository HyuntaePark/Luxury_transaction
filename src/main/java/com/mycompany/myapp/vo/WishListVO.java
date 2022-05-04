package com.mycompany.myapp.vo;

public class WishListVO {
	private int wishListId;
	private int wishListUserId;
	private int wishListItemId;
	public WishListVO() {
		super();
	}
	public int getWishListId() {
		return wishListId;
	}
	public void setWishListId(int wishListId) {
		this.wishListId = wishListId;
	}
	public int getWishListUserId() {
		return wishListUserId;
	}
	public void setWishListUserId(int wishListUserId) {
		this.wishListUserId = wishListUserId;
	}
	public int getWishListItemId() {
		return wishListItemId;
	}
	public void setWishListItemId(int wishListItemId) {
		this.wishListItemId = wishListItemId;
	}
	@Override
	public String toString() {
		return "WishListVO [wishListId=" + wishListId + ", wishListUserId=" + wishListUserId + ", wishListItemId="
				+ wishListItemId + "]";
	}
	
	
}
