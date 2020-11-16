package com.gf.guideforyou.vo;

public class MemberFindPw {

	private boolean pwExit;
	private String emailResult;
	
	
	public MemberFindPw() {
		super();
	}
	
	
	public MemberFindPw(boolean pwExit, String pwResult) {
		super();
		this.pwExit = pwExit;
		this.emailResult = pwResult;
	}


	public boolean isPwExit() {
		return pwExit;
	}


	public void setPwExit(boolean pwExit) {
		this.pwExit = pwExit;
	}


	public String getEmailResult() {
		return emailResult;
	}


	public void setEmailResult(String emailResult) {
		this.emailResult = emailResult;
	}
	
	
	
	
	
}
