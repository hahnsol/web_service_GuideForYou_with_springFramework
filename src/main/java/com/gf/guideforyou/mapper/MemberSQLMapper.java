package com.gf.guideforyou.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gf.guideforyou.vo.MemberBasicVo;



public interface MemberSQLMapper {

	
	@Select("SELECT * FROM GF_MEMBER WHERE MEMBER_IDX=#{member_idx}")
	public MemberBasicVo selectMemberInfoByMemberIdx(int member_idx);
	
	@Select("SELECT * FROM GF_MEMBER WHERE MEMBER_ID=#{member_id} AND MEMBER_QUIT='n'")
	public  MemberBasicVo selectMemberInfoByMemberId(String member_id);
	
	@Select("SELECT MEMBER_ID FROM GF_MEMBER WHERE MEMBER_NAME=#{member_name},MEMBER_AGE=#{member_age},MEMBER_PHONE={member_phone}")
	public MemberBasicVo selectFindId(MemberBasicVo vo);
	
	@Select("SELELCT MEMBER_PW, MEMBER_EMAIL FROM GF_MEMBER WHERE MEMBER_ID=#{member_id}, MEMBER_NAME=#{member_name}, MEMBER_PHONE=#{member_phone}")
	public MemberBasicVo selectFindPw(MemberBasicVo vo);


	

	//회원정보 수정 에 사용 하는  sql
	//현재  membner_profile_photo 가 안들어 가있음   작 업 후에  sql 문에 넣어 줘야함
	@Update("UPDATE GF_MEMBER SET MEMBER_PROFILE_PHOTO=#{member_profile_photo, jdbcType=VARCHAR}, MEMBER_NICK=#{member_nick},MEMBER_PHONE=#{member_phone},MEMBER_ADDRESS=#{member_address},MEMBER_KAKAO=#{member_kakao},MEMBER_EMAIL=#{member_email} WHERE MEMBER_IDX=#{member_idx}")
	public void updateMemberProfile(MemberBasicVo vo);

	
	@Update("UPDATE GF_MEMBER SET MEMBER_QUIT='y' , MEMBER_QUIT_DATE=SYSDATE WHERE MEMBER_IDX=#{member_idx}")
	public void updateQuitMember(MemberBasicVo vo);
	
	
	
	///추가
	
	
	@Select("SELECT * FROM GF_MEMBER WHERE MEMBER_NICK=#{member_nick}")
	public  MemberBasicVo selectMemberInfoByMembernick(String member_nick);
	//닉네임중복검사용 추가했습니다.(김효정)
	
	//name추가했습니다(김효정)
	@Insert("INSERT INTO GF_MEMBER VALUES(GF_MEMBER_SEQ.NEXTVAL,'n',#{member_id},#{member_pw},#{member_name},#{member_nick},"
				+ "#{member_phone},#{member_kakao},#{member_age},#{member_gender},#{member_address},#{member_email},SYSDATE,'n',NULL)")
	public void insertMember(MemberBasicVo vo);
		
	
	@Select ("SELECT MEMBER_ID FROM GF_MEMBER WHERE MEMBER_NAME=#{member_name} AND MEMBER_AGE=#{member_age} AND MEMBER_PHONE=#{member_phone}")
	public MemberBasicVo findMemberId(MemberBasicVo vo);
		  
	@Select ("SELECT * FROM GF_MEMBER WHERE MEMBER_ID=#{member_id} AND MEMBER_NAME=#{member_name} AND MEMBER_EMAIL=#{member_email}")
	public MemberBasicVo findMemberPw(MemberBasicVo vo);
	
	//비밀번호 랜덤 형성
	@Update("UPDATE GF_MEMBER SET MEMBER_PW=#{member_pw} WHERE MEMBER_IDX=#{member_idx}")
	public void updateRandomPw(MemberBasicVo vo);
	
		
}
