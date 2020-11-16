package com.gf.guideforyou.vo;

public class MemberFindId {

	private boolean idExit;
	private String idResult;
	
	
	public MemberFindId() {
		super();
	}
	
	
	public MemberFindId(boolean idExit, String idResult) {
		super();
		this.idExit = idExit;
		this.idResult = idResult;
	}
	
	
	public boolean isIdExit() {
		return idExit;
	}
	public void setIdExit(boolean idExit) {
		this.idExit = idExit;
	}
	public String getIdResult() {
		return idResult;
	}
	public void setIdResult(String idResult) {
		this.idResult = idResult;
	}
	
	
	
	
}
