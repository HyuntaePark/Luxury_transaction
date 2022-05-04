package com.mycompany.myapp.repository;

import java.util.List;

import com.mycompany.myapp.vo.NoticeVO;
import com.mycompany.myapp.vo.UserVO;

public interface IAdminRepository {
	List<NoticeVO> getNoticeList();
	NoticeVO getNoticeInfo(int noticeNo);
	void updateNotice(NoticeVO nvo);
	void deleteNotice(int noticeNo);
	void noticeInsert(NoticeVO vo);
	UserVO getUserInfo(int userId);

}
