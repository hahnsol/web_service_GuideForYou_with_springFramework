package com.gf.guideforyou.vo;

public class SessionUserDataVo {

	private int member_idx;
	private String member_nick;
	private String member_profile_photo;
	
	public SessionUserDataVo() {}

	
	public SessionUserDataVo(int member_idx, String member_nick, String member_profile_photo) {
		this.member_idx = member_idx;
		this.member_nick = member_nick;
		this.member_profile_photo = member_profile_photo;
	}


	public int getMember_idx() {
		return member_idx;
	}


	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}


	public String getMember_nick() {
		return member_nick;
	}


	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}


	public String getMember_profile_photo() {
		return member_profile_photo;
	}


	public void setMember_profile_photo(String member_profile_photo) {
		this.member_profile_photo = member_profile_photo;
	}
	 
	
}
