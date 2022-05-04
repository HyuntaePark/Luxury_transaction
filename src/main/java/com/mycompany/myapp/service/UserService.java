package com.mycompany.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.UserMapper;
import com.mycompany.myapp.repository.IUserRepository;
import com.mycompany.myapp.vo.CategoryVO;
import com.mycompany.myapp.vo.ProductVO;
import com.mycompany.myapp.vo.UploadFileVO;
import com.mycompany.myapp.vo.UserVO;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepository userRepository;
	
	//김지현
	@Inject
	private UserMapper mapper;
	
	@Override
	public UserVO getUserInfo(String userId) {
		return mapper.getUserInfo(userId);
	}
	
	public void insertUser(UserVO vo) {
		mapper.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		mapper.updateUser(vo);
	}

	@Override
	public void deleteUser(String userId, String userPassword) {
		mapper.deleteUser(userId, userPassword);
	}

	@Override
	public UserVO userLogin(UserVO vo) {
		return mapper.userLogin(vo);
	}

	@Override
	public int idCheck(String userId) {
		return mapper.idCheck(userId);
	}

	@Override
	public int pwCheck(String userId, String userPassword) {
		return mapper.pwCheck(userId, userPassword);
	}
	//-----------------------------------------------
	
	@Override
	public List<ProductVO> getCategoryAll() {
		return userRepository.getCategoryAll();
	}
	//윤민우 카테고리 Clothes
	@Override
	public List<ProductVO> getCategoryClothes() {
		return userRepository.getCategoryClothes();
	}
	//윤민우 카테고리 Shoes
	@Override
	public List<ProductVO> getCategoryShoes() {
		return userRepository.getCategoryShoes();
	}
	//윤민우 카테고리 Bag
	@Override
	public List<ProductVO> getCategoryBag() {
		return userRepository.getCategoryBag();
	}
	//윤민우 카테고리 Accessoris
	@Override
	public List<ProductVO> getCategoryAccessoris() {
		return userRepository.getCategoryAccessoris();
	}
	//윤민우 상품검색
	@Override
	public List<ProductVO> getSearchProduct(String productName) {
		return userRepository.getSearchProduct(productName);
	}
	//윤민우 상품번호 검색
	@Override
	public ProductVO getProductInfo(int productNo) {
		return userRepository.getProductInfo(productNo);
	}
	//윤민우 위시리스트 추가
	@Override
	public void setWishList(ProductVO vo) {
		userRepository.setWishList(vo);
	}
	
	//파일업로드
	@Override
	public void uploadFile(UploadFileVO file) {
		file.setFileNo(userRepository.getMaxFileId()+1);
		userRepository.uploadFile(file);
		
	}
	//유저 정보얻기
	@Override
	public UserVO getUserInfoByPrdNo(int productNo) {
		return userRepository.getUserInfoByPrdNo(productNo);
	}
	//카테고리 정보 얻기
	@Override
	public String getCategoryNameByPrdNo(int productNo) {
		return userRepository.getCategoryNameByPrdNo(productNo);
	}
	//이미지 출력
	@Override
	public List<UploadFileVO> getFileList(int productNo) {
		return userRepository.getFileList(productNo);
	}
	@Override
	public UploadFileVO getFile(int fileNo) {
		return userRepository.getFile(fileNo);
	}
	@Override
	public List<CategoryVO> getCategroyName(List<ProductVO> vo) {
		return userRepository.getCategroyName(vo);
	}
}
