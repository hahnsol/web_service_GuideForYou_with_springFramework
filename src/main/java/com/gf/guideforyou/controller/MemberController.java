package com.gf.guideforyou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gf.guideforyou.common.UploadFiles;
import com.gf.guideforyou.mapper.MemberSQLMapper;
import com.gf.guideforyou.service.*;
import com.gf.guideforyou.vo.*;
import org.springframework.ui.Model;

//컨트롤러 class를 추가할 경우 Member를 써주기
//포워딩 하는 변수에 member 적기 (소문자)
//session에 들어가는 정보는 "memberSession"으로 부탁드립니다.

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	
	
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "loginPage";
	}

	
	
	@RequestMapping("/joinMemberPage")
	public String joinMemberPage() {
		return "joinMemberPage";
	}

	
	@ResponseBody
	@RequestMapping("/joinMemberAction")
	public ValidateJoinMemberVo joinMemberAction(MemberBasicVo param) {

		ValidateJoinMemberVo joinResult = memberService.joinMember(param);

		return joinResult;
	}
	
	

	@RequestMapping("/loginAction")
	public String loginAction(MemberBasicVo param, HttpSession session) {

		SessionUserDataVo memberSession = memberService.login(param);

		if (memberSession == null) {
			return "loginFailPage";
		}
		session.setAttribute("memberSession", memberSession);
		return "redirect:indexPage";
	}

	
	
	@RequestMapping("/logoutAction")
	public String logoutAction(HttpSession session) {
		session.invalidate();
		return "redirect:indexPage";
	}
	
	
	
	
	@RequestMapping("/withdrawPage")
	public String withdrawPage(){
		return"widthdrawPage";
	}
	
	
	

	@RequestMapping("/withdrawAction")
	public String withdrawAction(MemberBasicVo param, HttpSession session) {

		SessionUserDataVo sessionVo = (SessionUserDataVo) session.getAttribute("memberSession");
		param.setMember_idx(sessionVo.getMember_idx());
		memberService.withdraw(param);
		return "indexPage";

	}
	
	
	
	@RequestMapping("/checkPasswordPage")
	public String checkPasswordPage() {
		
		return "checkPasswordPage";
	}
	
	

	@RequestMapping("/editProfilePage")
	public String editProfilePage(HttpSession session, Model model) {
		
		System.out.println("회원정보수정페이지시작-->");
		
		//세션에서 member_idx가져오기 
		SessionUserDataVo editProfileSessionData = (SessionUserDataVo)session.getAttribute("memberSession");
		int editProfileMember_idx = editProfileSessionData.getMember_idx();
		
		System.out.println("member_idx="+editProfileMember_idx);
		
		//member_idx를 이용해서 내정보 가져오기
		MemberBasicVo membervo = new MemberBasicVo();
		membervo.setMember_idx(editProfileMember_idx);
		
		MemberBasicVo memberEditProfileInfo = memberService.readProfile(membervo);
			
		model.addAttribute("memberEditProfileInfo", memberEditProfileInfo);	
			
		return "editProfilePage";
	}
	
	
	
	@RequestMapping("/editProfileAction")
	public String editProfileAction(MemberBasicVo param, MultipartFile[] files, HttpSession session) {
		
		System.out.println("파일저장시작-->");
		
		//upload 파일 저장 class
		UploadFiles uploadFile = new UploadFiles();
		
		ArrayList<String> linkList = uploadFile.uploadFileLinkName(files);
		
		//프로필사진의 링크를 데이터베이스에 넣어주기
		if(linkList.size()==1) {
			param.setMember_profile_photo(linkList.get(0));
			System.out.println("프로필사진저장완료");
		}
		
		//회원정보수정
		memberService.editProfile(param);
		
		SessionUserDataVo userSession = (SessionUserDataVo) session.getAttribute("memberSession");
		if(linkList.size() != 0 ) {
			userSession.setMember_profile_photo(linkList.get(0));
		}
		
		
		
		return "myPage";
	}
	
	
	@RequestMapping("/idReset")
	public String idReset() {
		
		return "idReset";
		
	}
	
	
	
	@RequestMapping("/passwordReset")
	public String passwordReset() {
		
		return "passwordReset";
	}
	


}
