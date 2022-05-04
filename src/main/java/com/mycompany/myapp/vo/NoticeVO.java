package com.mycompany.myapp.vo;

import java.sql.Date;

public class NoticeVO {
	private int noticeNo; 
	private String noticeUserId;
	private String noticeTitle;
	private String noticeDescription;
	private Date noticeDate;
	public NoticeVO() {
		super();
	}
	
	public NoticeVO(int noticeNo, String noticeUserId, String noticeTitle, String noticeDescription, Date noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeUserId = noticeUserId;
		this.noticeTitle = noticeTitle;
		this.noticeDescription = noticeDescription;
		this.noticeDate = noticeDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeUserId() {
		return noticeUserId;
	}

	public void setNoticeUserId(String noticeUserId) {
		this.noticeUserId = noticeUserId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeDescription() {
		return noticeDescription;
	}

	public void setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	@Override
	public String toString() {
		return "NoticeVO [notice_id=" + noticeNo + ", notice_user_no=" + noticeUserId + ", notice_title="
				+ noticeTitle + ", notice_description=" + noticeDescription + ", notice_date=" + noticeDate + "]";
	}
	
}
