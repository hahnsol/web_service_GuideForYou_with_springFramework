package com.gf.guideforyou.service;

import com.gf.guideforyou.vo.*;

public interface MemberService {

public abstract ValidateJoinMemberVo joinMember(MemberBasicVo memberBasicVo);
	
	public abstract SessionUserDataVo login(MemberBasicVo memberBasicVo);
	
	public abstract void withdraw(MemberBasicVo memberBasicVo); 
	
	public abstract boolean checkPassword(MemberBasicVo memberBasicVo);
	
	public abstract void editProfile (MemberBasicVo memberBasicvo);
	
	public MemberBasicVo readProfile(MemberBasicVo memberVo); 
	
	public void passwordMaker(MemberBasicVo memberVo);
}
