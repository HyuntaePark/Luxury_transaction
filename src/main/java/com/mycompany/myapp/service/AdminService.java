package com.mycompany.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.AdminMapper;
import com.mycompany.myapp.repository.IAdminRepository;
import com.mycompany.myapp.vo.NoticeVO;
import com.mycompany.myapp.vo.UserVO;

@Service
@Qualifier("adservice")
public class AdminService implements IAdminService{
	
	@Inject
	private AdminMapper mapper;
	
	@Autowired
	IAdminRepository adminRepository;
	
	
	// 로그인 처리
	@Override
	public UserVO adminLogin(UserVO vo) {
		return mapper.adminLogin(vo);
	}
	
	// 사용자 정보
	@Override
	public UserVO userInfo(int userId) {
		return adminRepository.getUserInfo(userId);
	}

	// 공지사항 목록
	@Override
	public List<NoticeVO> getNoticeList() {
		return adminRepository.getNoticeList();
	}

	// 공지사항 세부내용
	@Override
	public NoticeVO getnoticeInfo(int noticeNo) {
		return adminRepository.getNoticeInfo(noticeNo);
	}
	
	@Override
	public void updateNotice(NoticeVO nvo) {
		adminRepository.updateNotice(nvo);
		
	}

	@Override
	public void deleteNotice(int noticeNo) {
		adminRepository.deleteNotice(noticeNo);
	}

	@Override
	public void noticeInsert(NoticeVO vo) {
		adminRepository.noticeInsert(vo);
		
	}





}
