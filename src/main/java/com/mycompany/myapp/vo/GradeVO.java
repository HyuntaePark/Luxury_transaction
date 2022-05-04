package com.mycompany.myapp.vo;

public class GradeVO {
	private int gradeStar;
	private int gradeUserId;
	private int gradeProductNo;
	
	public GradeVO() {
		super();
	}

	public int getGradeStar() {
		return gradeStar;
	}

	public void setGradeStar(int gradeStar) {
		this.gradeStar = gradeStar;
	}

	public int getGradeUserId() {
		return gradeUserId;
	}

	public void setGradeUserId(int gradeUserId) {
		this.gradeUserId = gradeUserId;
	}

	public int getGradeProductNo() {
		return gradeProductNo;
	}

	public void setGradeProductNo(int gradeProductNo) {
		this.gradeProductNo = gradeProductNo;
	}

	@Override
	public String toString() {
		return "GradeVO [gradeStar=" + gradeStar + ", gradeUserId=" + gradeUserId + ", gradeProductNo=" + gradeProductNo
				+ "]";
	}
	
}
