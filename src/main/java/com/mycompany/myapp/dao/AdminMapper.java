package com.mycompany.myapp.dao;

import com.mycompany.myapp.vo.UserVO;

public interface AdminMapper {
	// 로그인처리
	public UserVO adminLogin(UserVO vo);
}
