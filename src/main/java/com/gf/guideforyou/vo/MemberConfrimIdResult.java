package com.gf.guideforyou.vo;

public class MemberConfrimIdResult {

	private boolean existId;
	private String etc;
	
	public MemberConfrimIdResult() {
		super();
	}
	
	public MemberConfrimIdResult(boolean existId, String etc) {
		super();
		this.existId = existId;
		this.etc = etc;
	}
	
	public boolean isExistId() {
		return existId;
	}
	public void setExistId(boolean existId) {
		this.existId = existId;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	

	
}
