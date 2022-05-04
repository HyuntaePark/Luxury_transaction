package com.mycompany.myapp.repository;

import java.util.List;

import com.mycompany.myapp.vo.CategoryVO;
import com.mycompany.myapp.vo.ProductVO;
import com.mycompany.myapp.vo.UploadFileVO;
import com.mycompany.myapp.vo.UserVO;

public interface IUserRepository {
	List<ProductVO> getCategoryAll();						//윤민우 카테고리 All
	List<ProductVO> getCategoryClothes();					//윤민우 카테고리 Clothes
	List<ProductVO> getCategoryShoes();						//윤민우 카테고리 Shoes
	List<ProductVO> getCategoryBag();						//윤민우 카테고리 Bag
	List<ProductVO> getCategoryAccessoris();				//윤민우 카테고리 Accessoris
	List<ProductVO> getSearchProduct(String productName);	//윤민우 상품 검색
	List<CategoryVO> getCategroyName(List<ProductVO> vo);	//윤민우 카테고리 이름 가져오기
	ProductVO getProductInfo(int productNo);				//윤민우 상품번호 검색
	void setWishList(ProductVO vo);							//윤민우 위시리스트 추가
	void uploadFile(UploadFileVO file);						//파일 업로드
	int getMaxFileId();										//파일의 마지막알아오기
	UserVO getUserInfoByPrdNo(int productNo);				//상품번호로 유저정보 가져오기
	String getCategoryNameByPrdNo(int productNo);			//상품번호로 카테고리 이름 가져오기
	List<UploadFileVO> getFileList(int productNo);			//이미지 파일 리스트 불러오기
	UploadFileVO getFile(int fileNo);						//파일 업로드
}
