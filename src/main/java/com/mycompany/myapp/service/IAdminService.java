package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.vo.NoticeVO;
import com.mycompany.myapp.vo.UserVO;

public interface IAdminService {
	public UserVO adminLogin(UserVO vo);
	List<NoticeVO> getNoticeList();
	public NoticeVO getnoticeInfo(int noticeNo);
	void updateNotice(NoticeVO nvo);
	void deleteNotice(int noticeNo);
	public void noticeInsert(NoticeVO vo);
	UserVO userInfo(int userId);
	
}
