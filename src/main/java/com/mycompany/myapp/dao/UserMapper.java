package com.mycompany.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycompany.myapp.vo.CategoryVO;
import com.mycompany.myapp.vo.ProductVO;
import com.mycompany.myapp.vo.UserVO;

public interface UserMapper {
	UserVO getUserInfo(String userId);
	void insertUser(UserVO vo);
	void updateUser(UserVO vo);
	void deleteUser(@Param("userId")String userID, @Param("userPassword")String userPassword);
	public UserVO userLogin(UserVO vo);
	int idCheck(String userId);
	int pwCheck(@Param("userId")String userId, @Param("userPassword")String userPassword);
}
