package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.vo.CategoryVO;
import com.mycompany.myapp.vo.ProductVO;
import com.mycompany.myapp.vo.UploadFileVO;
import com.mycompany.myapp.vo.UserVO;

public interface IUserService {
	//김지현
	UserVO getUserInfo(String userId);
	void insertUser(UserVO vo);
	void updateUser(UserVO vo);
	void deleteUser(String userId, String userPassword);
	UserVO userLogin(UserVO vo);
	int idCheck(String userId);
	int pwCheck(String userId, String userPassword);
	//-------------------------------------------
	
	List<ProductVO> getCategoryAll();							//윤민우 카테고리 All
	List<ProductVO> getCategoryClothes();						//윤민우 카테고리 Clothes
	List<ProductVO> getCategoryShoes();							//윤민우 카테고리 Shoes
	List<ProductVO> getCategoryBag();							//윤민우 카테고리 Bag
	List<ProductVO> getCategoryAccessoris();					//윤민우 카테고리 Accessoris
	List<ProductVO> getSearchProduct(String productName);		//윤민우 상품 검색
	List<CategoryVO> getCategroyName(List<ProductVO> vo);		//윤민우 카테고리 이름 가져오기
	ProductVO getProductInfo(int productNo);					//윤민우 상품번호로 검색
	void setWishList(ProductVO vo);								//위시리스트 추가
	void uploadFile(UploadFileVO file);							//파일 업로드
	UserVO getUserInfoByPrdNo(int productNo);
	String getCategoryNameByPrdNo(int productNo);
	List<UploadFileVO> getFileList(int productNo);
	UploadFileVO getFile(int fileNo);
}
