package com.mycompany.myapp.vo;

import java.util.Arrays;

public class ImageVO {
	private int imageId;
	private byte[] imageFile;
	
	public ImageVO() {
		super();
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public byte[] getImageFile() {
		return imageFile;
	}
	public void setImageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}
	@Override
	public String toString() {
		return "ImageVO [imageId=" + imageId + ", imageFile=" + Arrays.toString(imageFile) + "]";
	}

	
}
