package com.gf.guideforyou.controller;

import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gf.guideforyou.mapper.MemberSQLMapper;
import com.gf.guideforyou.service.MemberService;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.MemberConfirmNickResult;
import com.gf.guideforyou.vo.MemberConfrimIdResult;
import com.gf.guideforyou.vo.MemberFindId;
import com.gf.guideforyou.vo.MemberFindPw;
import com.gf.guideforyou.vo.MemberUpdateMyProfileVo;
import com.gf.guideforyou.vo.SessionUserDataVo;

@Controller
@ResponseBody
public class MemberRestController {

	@Autowired
	public MemberSQLMapper memberSQLMapper;

	@Autowired
	private MemberService memberService;

	@RequestMapping("/confirmId")
	public MemberConfrimIdResult confirmId(String id) {

		if (memberSQLMapper.selectMemberInfoByMemberId(id) ==  null ) {
			return new MemberConfrimIdResult(false, "사용 가능한  아이디 입니다");
		} else {
			return new MemberConfrimIdResult(true, "이미 존재하는 아이디 입니다");
		}

	}
	
	
	
	
	
	@RequestMapping ("/confirmNick")
	public MemberConfirmNickResult corinfirmNick(String nick) {
		System.out.println(memberSQLMapper.selectMemberInfoByMembernick(nick));
		
		if(memberSQLMapper.selectMemberInfoByMembernick(nick) == null) {
			System.out.println("a");
			return new MemberConfirmNickResult(false, "사용가능한 닉네임 입니다");
			
		} else {
			System.out.println("b");
			return new MemberConfirmNickResult(true, "이미 존재하는 닉네임 입니다");
			}
			
		
	}
	
	
	
	
	@RequestMapping("/rest_idReset")
	public MemberFindId rest_IdRest(MemberBasicVo param) {
		
		MemberBasicVo result = memberSQLMapper.findMemberId(param);
		
		if(result == null) {
			return new MemberFindId(false, "입력한 정보가 없습니다");
		}
		else {
			return new MemberFindId(true, result.getMember_id());
		}
		
	}
	
	
	
	@RequestMapping("/rest_pwReset")
	public MemberFindPw rest_PwReset(MemberBasicVo param) {
		
		MemberBasicVo result = memberSQLMapper.findMemberPw(param);
		
		
			if(result == null) {
				return new MemberFindPw(false, "입력한 정보가 없습니다");
			}
			else {
				
				memberService.passwordMaker(result);
				return new MemberFindPw(true, result.getMember_email());
			}
		
		
		
	}
	
	
	@RequestMapping("/rest_checkPasswordAction")
	public MemberUpdateMyProfileVo rest_checkPasswordAction(MemberBasicVo memberBasicVo, HttpSession session){
		
		SessionUserDataVo sessionUser = (SessionUserDataVo)session.getAttribute("memberSession");
		int memberIdx=sessionUser.getMember_idx();
		memberBasicVo.setMember_idx(memberIdx);
		
		
		
		if (memberService.checkPassword(memberBasicVo) == true) {
			
			return new MemberUpdateMyProfileVo(true);
			
		}
		else {
			
			return new MemberUpdateMyProfileVo(false);
			} 
	}
	
	

}
