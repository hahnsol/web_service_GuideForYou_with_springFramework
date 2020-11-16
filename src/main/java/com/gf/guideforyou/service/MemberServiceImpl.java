package com.gf.guideforyou.service;

import org.springframework.stereotype.Service;


import com.gf.guideforyou.mapper.MemberSQLMapper;
import com.gf.guideforyou.validate.BirthCheck;
import com.gf.guideforyou.validate.Multy_phone_engish;
import com.gf.guideforyou.validate.OnlyInteger;
import com.gf.guideforyou.validate.Only_email;
import com.gf.guideforyou.validate.Only_english_number;
import com.gf.guideforyou.validate.Only_korea;
import com.gf.guideforyou.validate.Only_phone;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.MemberConfrimIdResult;
import com.gf.guideforyou.vo.SessionUserDataVo;
import com.gf.guideforyou.vo.ValidateJoinMemberVo;

import java.security.MessageDigest;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.aop.aspectj.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired 
	private JavaMailSender mailSender;
	@Autowired
	private MemberSQLMapper memberSQLMapper;

	public ValidateJoinMemberVo joinMember(MemberBasicVo memberBasicVo) {
		
		//아이디 정규식 검사
		Only_english_number id_english_number = new Only_english_number(memberBasicVo.getMember_id());
		//비밀번호 정규식 검사
		OnlyInteger pw_onlyInteger = new OnlyInteger(memberBasicVo.getMember_pw());
		//이름 정규식 검사
		Only_korea name_only_korea = new Only_korea(memberBasicVo.getMember_name()); 
		//닉네임 정규식 검사
		Only_english_number nick_english_number = new Only_english_number(memberBasicVo.getMember_nick());
		//휴대 전화 정규식 검사
		Only_phone phone_only_phone = new Only_phone(memberBasicVo.getMember_phone());
		//연락수단 정규식검사
		Multy_phone_engish kakao_phone_engish = new Multy_phone_engish(memberBasicVo.getMember_kakao());
		
		//생년월일 성인 검사
		BirthCheck memberBirthComfirm = new BirthCheck(memberBasicVo.getMember_age());
		//이메일 정규식 검사
		Only_email only_email = new Only_email(memberBasicVo.getMember_email());
		
		
		
		if(memberBasicVo.getMember_id() != null && id_english_number.compareValue().equals("true")) {
				if(memberBasicVo.getMember_name() !=null && !memberBasicVo.getMember_name().equals("")) {
					if(memberBasicVo.getMember_nick() != null && nick_english_number.compareValue().equals("true")) {
						if(memberBasicVo.getMember_phone() != null && phone_only_phone.compareValue().equals("true")) {
							if(memberBasicVo.getMember_kakao() != null && kakao_phone_engish.compareValue().equals("true")) {
								if(memberBasicVo.getMember_age() != null && !memberBasicVo.getMember_age().equals("") ) {
									if(memberBasicVo.getMember_age() !=null && memberBirthComfirm.compareDate().equals("true")) {
										if(memberBasicVo.getMember_email() != null && only_email.compareValue().equals("true")){
											
											//전부 제대로 들어올경우 복호화 후 회원가입
											String message = memberBasicVo.getMember_pw();
											String hashCode = null;
											
											StringBuilder sb = new StringBuilder();
											
											try {
												MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

												messageDigest.reset();
												messageDigest.update(message.getBytes("UTF-8"));

												byte[] chars = messageDigest.digest();

												for (int i = 0; i < chars.length; i++) {
													String tmp = Integer.toHexString(0xff & chars[i]);
													if (tmp.length() == 1)
														sb.append("0");
													sb.append(tmp);
												}

												hashCode = sb.toString();
												
											} catch (Exception e) {
												e.printStackTrace();
											}
											
											System.out.println("입력 값 : " + message);
											System.out.println("변환된 해쉬 값 : " + hashCode);

											memberBasicVo.setMember_pw(hashCode);
											
											memberSQLMapper.insertMember(memberBasicVo);
											
											
											return new ValidateJoinMemberVo(true,"회원가입 성공");
										}else {
											return new ValidateJoinMemberVo(false,"이메일");
										}
									}else {
										return new ValidateJoinMemberVo(false,"미성년자는 가입할수 없습니다");
									}
									
								}else {
									return new ValidateJoinMemberVo(false,"생년월일");
								}
							}else {
								return new ValidateJoinMemberVo(false,"연락수단");
							}
						}else {
							return new ValidateJoinMemberVo(false,"휴대전화");
						}
					}else {
						return new ValidateJoinMemberVo(false,"닉네임");
					}
				}else {
					return new ValidateJoinMemberVo(false,"이름");
				}
			
		}else {
			return new ValidateJoinMemberVo(false,"아이디");
		}


	}

	
	
	
	@Override
	public SessionUserDataVo login(MemberBasicVo memberBasicVo) {

		MemberBasicVo memberVo = memberSQLMapper.selectMemberInfoByMemberId(memberBasicVo.getMember_id());

		String message = memberBasicVo.getMember_pw();
		String hashCode = null;
		
		StringBuilder sb = new StringBuilder();
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

			messageDigest.reset();
			messageDigest.update(message.getBytes("UTF-8"));

			byte[] chars = messageDigest.digest();

			for (int i = 0; i < chars.length; i++) {
				String tmp = Integer.toHexString(0xff & chars[i]);
				if (tmp.length() == 1)
					sb.append("0");
				sb.append(tmp);
			}

			hashCode = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		if (memberVo != null && memberVo.getMember_pw().equals(hashCode)) {

			SessionUserDataVo sessionUserDataVo = new SessionUserDataVo(memberVo.getMember_idx(),
					memberVo.getMember_nick(), memberVo.getMember_profile_photo());
			return sessionUserDataVo;
		}

		return null;

	}
	

	@Override
	public void withdraw(MemberBasicVo memberBasicVo) {
		
		memberSQLMapper.updateQuitMember(memberBasicVo);
	
		
		
	}
	

	@Override
	public boolean checkPassword(MemberBasicVo memberBasicVo) {
		
		
		//사용자의 idx를 통한 비밀번호 가져옴
		MemberBasicVo memberVo = memberSQLMapper.selectMemberInfoByMemberIdx(memberBasicVo.getMember_idx());
		
		
		//입력된 비밀번호를 복호화함
		String message = memberBasicVo.getMember_pw();
		String hashCode = null;
		
		StringBuilder sb = new StringBuilder();
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

			messageDigest.reset();
			messageDigest.update(message.getBytes("UTF-8"));

			byte[] chars = messageDigest.digest();

			for (int i = 0; i < chars.length; i++) {
				String tmp = Integer.toHexString(0xff & chars[i]);
				if (tmp.length() == 1)
					sb.append("0");
				sb.append(tmp);
			}

			hashCode = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("입력 값 : " + message);
		System.out.println("변환된 해쉬 값 : " + hashCode);

		
		
		if(memberVo !=null && memberVo.getMember_pw().equals(hashCode)) {
			return true;
		
		}else
			return false;
	}
	
	@Override
	public void editProfile(MemberBasicVo memberBasicVo) {
		
		memberSQLMapper.updateMemberProfile(memberBasicVo);
		
	}

	@Override
	public MemberBasicVo readProfile(MemberBasicVo memberBasicVo) {
		MemberBasicVo memberVo = memberSQLMapper.selectMemberInfoByMemberIdx(memberBasicVo.getMember_idx());
		
		return memberVo;
	}

	
	
	
	@Override
	public void passwordMaker(MemberBasicVo memberBasicVo) {
	
		System.out.println(memberBasicVo.getMember_email());
		String randomPw = RandomStringUtils.randomAlphabetic(8);
		System.out.println(randomPw);
		
		memberBasicVo.setMember_pw(randomPw);
		memberSQLMapper.updateRandomPw(memberBasicVo);
	
		sendMailTread sendThread = new sendMailTread(mailSender, memberBasicVo);
		
		sendThread.start();
			   
		
		
	}
	
}


///메일 쓰래드
class sendMailTread extends Thread{
	
	private JavaMailSender mailSender;
	private MemberBasicVo param;
	

	public sendMailTread(JavaMailSender mailSender, MemberBasicVo param) {
		super();
		this.mailSender = mailSender;
		this.param = param;
	}




	public void run() {
	
		try {
			
			MimeMessage message = null;
			MimeMessageHelper messageHelper = null;
			message = mailSender.createMimeMessage();
			System.out.println("메일전송 준비");
			System.out.println(message);
			messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject("가이드포유 임시비밀번호"); // 제목
			messageHelper.setText("가이드포유 임시 비밀번호는  "+param.getMember_pw()+
					"  입니다", true);
			messageHelper.setFrom("admin", "관리자");
			messageHelper.setTo(param.getMember_email());
			// messageHelper.addInline(contentId, dataSource);
			mailSender.send(message);
        
			System.out.println("전송완료");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}





















