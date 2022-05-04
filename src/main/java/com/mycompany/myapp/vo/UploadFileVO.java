package com.mycompany.myapp.vo;

import java.sql.Timestamp;
import java.util.Arrays;

public class UploadFileVO {
	private	int	fileNo;
	private	int productNo;
	private	String fileName;
	private	long fileSize;
	private	String fileContentType;
	private	Timestamp fileUploadDate;
	private	byte[] fileData;
	

	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public Timestamp getFileUploadDate() {
		return fileUploadDate;
	}
	public void setFileUploadDate(Timestamp fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "UploadFileVO [fileNo=" + fileNo + ", productNo=" + productNo + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", fileContentType=" + fileContentType + ", fileUploadDate=" + fileUploadDate
				+ ", fileData=" + Arrays.toString(fileData) + "]";
	}
	


	
}
