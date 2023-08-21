package com.ncs.test.member.model.vo;

public class Member {
	
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberEnrollDate;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberEnrollDate = memberEnrollDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEnrollDate() {
		return memberEnrollDate;
	}

	public void setMemberEnrollDate(String memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + "]";
	}


	
	
	
	
	
	

}
