package com.mycompany.myapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myapp.vo.NoticeVO;
import com.mycompany.myapp.vo.UserVO;
@Repository
public class AdminRepository implements IAdminRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class UserMapper implements RowMapper<UserVO>{

		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO vo = new UserVO();
			vo.setUserId(rs.getString("userId"));
			vo.setUserPassword(rs.getString("userPassword"));
			vo.setUserName(rs.getString("userName"));
			vo.setUserBirth(rs.getDate("userBirth"));
			vo.setUserAddress(rs.getString("userAddress"));
			vo.setUserPhone(rs.getString("userPhone"));
			vo.setUserSignup(rs.getDate("userSignup"));
			vo.setUserIsAdmin(rs.getString("userIsAdmin"));
			return vo;
		}
		
	}
	
	private class NoticeMapper implements RowMapper<NoticeVO>{

		@Override
		public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			NoticeVO nvo = new NoticeVO();
			nvo.setNoticeNo(rs.getInt("noticeNo"));
			nvo.setNoticeTitle(rs.getString("noticeTitle"));
			nvo.setNoticeDescription(rs.getString("noticeDescription"));
			nvo.setNoticeUserId(rs.getString("noticeUserId"));
			nvo.setNoticeDate(rs.getDate("noticeDate"));
			return nvo;
		}
		
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		String sql = "SELECT NOTICE_NO AS noticeNo, "
				+ " NOTICE_TITLE AS noticeTitle, "
				+ " NOTICE_DESCRIPTION AS noticeDescription, "
				+ " NOTICE_USER_ID AS noticeUserId, "
				+ " NOTICE_DATE AS noticeDate "
				+ " from NOTICE "
				+ " ORDER BY NOTICE_NO";
		return jdbcTemplate.query(sql, new NoticeMapper());
	}

	@Override
	public NoticeVO getNoticeInfo(int noticeNo) {
		String sql = "SELECT NOTICE_NO AS noticeNo, "
				+ " NOTICE_TITLE AS noticeTitle, "
				+ " NOTICE_DESCRIPTION AS noticeDescription, "
				+ " NOTICE_USER_ID AS noticeUserId, "
				+ " NOTICE_DATE AS noticeDate "
				+ " from NOTICE "
				+ " WHERE NOTICE_NO=? ";
		return jdbcTemplate.queryForObject(sql, new NoticeMapper(), noticeNo);
	}

	@Override
	public void updateNotice(NoticeVO nvo) {
		String sql = "update notice set NOTICE_TITLE=?, NOTICE_DESCRIPTION=?"
				+ " WHERE NOTICE_NO=? ";
		jdbcTemplate.update(sql, nvo.getNoticeTitle(),
								nvo.getNoticeDescription(),
								nvo.getNoticeNo()
		);
		
	}

	@Override
	@Transactional
	public void deleteNotice(int noticeNo) {
		String sql = "delete from notice where notice_no=?";
		jdbcTemplate.update(sql, noticeNo);
		
	}

	// 공지사항 등록
	@Override
	public void noticeInsert(NoticeVO nvo) {
		String sql = "insert into notice (NOTICE_NO, NOTICE_TITLE, "
				+ " NOTICE_DESCRIPTION, NOTICE_USER_ID, NOTICE_DATE) "
				+ " values (NOTICE_SEQ.NEXTVAL, ?, ?, ?, sysdate)";
		System.out.println("=========");
		System.out.println(nvo.getNoticeTitle());
		
		jdbcTemplate.update(sql, nvo.getNoticeTitle(),
								nvo.getNoticeDescription(),
								nvo.getNoticeUserId()
		);
	}

	@Override
	public UserVO getUserInfo(int userId) {
		String sql = "select * from user where user_id=? ";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), userId);
	}

	

	
}
