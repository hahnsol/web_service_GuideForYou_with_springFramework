package com.gf.guideforyou.vo;

public class ValidateJoinMemberVo {

	private boolean valid;
	private String emptySpace;
	
	public ValidateJoinMemberVo() {
		super();
	}

	public ValidateJoinMemberVo(boolean valid, String emptySpace) {
		super();
		this.valid = valid;
		this.emptySpace = emptySpace;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getEmptySpace() {
		return emptySpace;
	}

	public void setEmptySpace(String emptySpace) {
		this.emptySpace = emptySpace;
	}

	
	
	
	
}
