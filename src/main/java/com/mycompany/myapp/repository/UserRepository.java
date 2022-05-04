package com.mycompany.myapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.vo.CategoryVO;
import com.mycompany.myapp.vo.ProductVO;
import com.mycompany.myapp.vo.UploadFileVO;
import com.mycompany.myapp.vo.UserVO;


@Repository
public class UserRepository implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class UserMapper implements RowMapper<UserVO> {
		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO vo = new UserVO();
			vo.setUserId(rs.getString("user_id"));
			vo.setUserPassword(rs.getString("user_password"));
			vo.setUserName(rs.getString("user_name"));
			vo.setUserBirth(rs.getDate("user_birth"));
			vo.setUserAddress(rs.getString("user_address"));
			vo.setUserPhone(rs.getString("user_phone"));
			vo.setUserSignup(rs.getDate("user_signup"));
			vo.setUserIsAdmin(rs.getString("user_isadmin"));
			return vo;
		}			
	}
	
	private class ProductMapper implements RowMapper<ProductVO> {
		@Override
		public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductVO vo = new ProductVO();
			vo.setProductNo(rs.getInt("product_no"));
			vo.setProductCategoryNo(rs.getInt("product_category_no"));
			vo.setSallerUserId(rs.getString("saller_user_id"));
			vo.setProductName(rs.getString("product_name"));
			vo.setProductPrice(rs.getInt("product_price"));
			vo.setProductDescription(rs.getString("product_description"));
			vo.setProductSaleStatusId(rs.getInt("product_sale_status_id"));
			return vo;
		}			
	}
	
	private class CategoryMapper implements RowMapper<CategoryVO> {
		@Override
		public CategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategoryVO vo = new CategoryVO();
			vo.setCategoryNo(rs.getInt("category_no"));
			vo.setCategoryName(rs.getString("category_name"));

			return vo;
		}			
	}
	
	//-----------------------------------------------------------------------------------
	
	//윤민우 카테고리 All
	@Override
	public List<ProductVO> getCategoryAll() {
		String sql = "select * from product";
		return jdbcTemplate.query(sql, new ProductMapper());	
	}
	
	//윤민우 카테고리 Clothes
	@Override
	public List<ProductVO> getCategoryClothes() {
		String sql = "select * from product where product_category_no = 2";
		return jdbcTemplate.query(sql, new ProductMapper());	
	}
	//윤민우 카테고리 Shoes
	@Override
	public List<ProductVO> getCategoryShoes() {
		String sql = "select * from product where product_category_no = 3";
		return jdbcTemplate.query(sql, new ProductMapper());
	}
	//윤민우 카테고리 Bag
	@Override
	public List<ProductVO> getCategoryBag() {
		String sql = "select * from product where product_category_no = 4";
		return jdbcTemplate.query(sql, new ProductMapper());
	}
	//윤민우 카테고리 Accessoris
	@Override
	public List<ProductVO> getCategoryAccessoris() {
		String sql = "select * from product where product_category_no = 5";
		return jdbcTemplate.query(sql, new ProductMapper());
	}
	//윤민우 검색박스 검색
	@Override
	public List<ProductVO> getSearchProduct(String productName) {
		String sql = "select * from product where product_name like ?";
		return jdbcTemplate.query(sql, new ProductMapper(), "%"+ productName + "%");
	}
	//윤민우 상품 번호로 검색
	@Override
	public ProductVO getProductInfo(int productNo) {
		String sql = "select * " 
				  + " from product"  
				  + " where product_no=?";
		return jdbcTemplate.queryForObject(sql, new ProductMapper(), productNo);
	}
	//윤민우 위시리스트 추가
	@Override
	public void setWishList(ProductVO vo) {
		String sql = "insert into wishlist (wishlist_no, wishlist_user_id, wishlist_product_no)"
				+ " values(WISHLIST_SEQ.nextval, ?, ?)";
		jdbcTemplate.update(sql, vo.getSallerUserId(), vo.getProductNo());
	}
	//윤민우 카테고리 이름 가져오기
	@Override
	public List<CategoryVO> getCategroyName(List<ProductVO> vo) {
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		
		for(ProductVO i : vo) {
			String sql = "select category_name from categories"
					+ " where category_no = ?";
			categoryList.add(jdbcTemplate.queryForObject(sql, new CategoryMapper(), i.getProductCategoryNo())); 
		}		
		return categoryList;
	}
	
	//파일 업로드
	@Override
	public int getMaxFileId() {
		String sql = "SELECT NVL(MAX(file_no),0) FROM PRODUCT_IMAGE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	@Override
	public void uploadFile(UploadFileVO file) {
		String	sql	= "INSERT INTO PRODUCT_IMAGE (file_no, product_no ,file_name, file_size,"
				+ " file_content_type, file_upload_date, file_data) VALUES (?, ?, ?, ?, ?, SYSTIMESTAMP, ?)";
				jdbcTemplate.update(sql,
				file.getFileNo(),
				1,
				file.getFileName(),	
				file.getFileSize(),	
				file.getFileContentType(),
				file.getFileData()
				);
		
	}
	
	//유저정보 
	@Override
	public UserVO getUserInfoByPrdNo(int productNo) {
		String sql = "select user_id, user_password, user_name, user_birth, user_address, user_phone, user_signup, user_isadmin"
				+ " from users, product where users.user_id = product.saller_user_id and product.product_no =?";		
		return jdbcTemplate.queryForObject(sql, new UserMapper(), productNo);
	}
	//카테고리 정보
	@Override
	public String getCategoryNameByPrdNo(int productNo) {
		String sql = "select category_name from categories, product where categories.category_no = product.product_category_no and product.product_no =?";		
		return jdbcTemplate.queryForObject(sql, String.class, productNo);
	}
	
	//이미지 출력
	public List<UploadFileVO> getFileList(int productNo) {
		String sql = "SELECT FILE_NO AS fileNo,"	
				+	" PRODUCT_NO AS productNo,"	
				+	" FILE_NAME AS	fileName,"
				+	" FILE_SIZE AS	fileSize,"
				+	" FILE_CONTENT_TYPE AS fileContentType,"
				+	" FILE_UPLOAD_DATE AS fileUploadDate"
				+	" FROM PRODUCT_IMAGE"	
				+	" WHERE	product_no=?"
				+	" ORDER	BY FILE_UPLOAD_DATE	DESC";
		
		return	jdbcTemplate.query(sql,	new	RowMapper<UploadFileVO>(){
				@Override
				public UploadFileVO	mapRow(ResultSet rs, int rowNum) throws	
				SQLException {
				UploadFileVO file =	new	UploadFileVO();
						file.setFileNo(rs.getInt("fileNo"));
						file.setProductNo(rs.getInt("productNo"));
						file.setFileName(rs.getString("fileName"));
						file.setFileSize(rs.getLong("fileSize"));
						file.setFileContentType(rs.getString("fileContentType"));
						file.setFileUploadDate(rs.getTimestamp("fileUploadDate"));
						return file;
						}
				},	productNo);
	}
	
	@Override
	public UploadFileVO getFile(int fileNo) {
		String sql = "SELECT FILE_NO AS	fileNo,"	
				+ " PRODUCT_NO AS productNo,"	
				+ " FILE_NAME AS fileName,"
				+ " FILE_SIZE AS fileSize,"
				+ " FILE_CONTENT_TYPE AS fileContentType,"	
				+ " FILE_DATA AS fileData"
				+ "	FROM PRODUCT_IMAGE"
				+ "	WHERE FILE_NO=?";
		
		return jdbcTemplate.queryForObject(sql,	new	RowMapper<UploadFileVO>(){
			@Override
			public	UploadFileVO	mapRow(ResultSet	rs,	int	rowNum)	throws	
				SQLException {
					UploadFileVO file =	new	UploadFileVO();
					file.setFileNo(rs.getInt("fileNo"));
					file.setProductNo(rs.getInt("productNo"));
					file.setFileName(rs.getString("fileName"));
					file.setFileSize(rs.getLong("fileSize"));
					file.setFileContentType(rs.getString("fileContentType"));
					file.setFileData(rs.getBytes("fileData"));
					return	file;
				}
			},	fileNo);
	}
}
