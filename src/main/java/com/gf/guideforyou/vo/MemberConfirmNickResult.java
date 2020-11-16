package com.gf.guideforyou.vo;

public class MemberConfirmNickResult {

	private boolean existNick;
	private String etc;
	
	public MemberConfirmNickResult() {
		super();
	}
	
	public MemberConfirmNickResult(boolean existNick, String etc) {
		super();
		this.existNick = existNick;
		this.etc = etc;
	}

	public boolean isExistNick() {
		return existNick;
	}

	public void setExistNick(boolean existNick) {
		this.existNick = existNick;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	

}
