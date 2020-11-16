package com.gf.guideforyou.controller;

import java.io.File;
import java.util.*;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.ResolverUtil.IsA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gf.guideforyou.common.UploadFiles;
import com.gf.guideforyou.service.MainContentService;
import com.gf.guideforyou.vo.*;


//컨트롤러 class를 추가할 경우 Main 써주기
//포워딩 하는 변수에 main 적기 (소문자)

@Controller
public class MainContentController {
	
	@Autowired
	private MainContentService mainContentService;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		return indexPage(model);
	}
	
	
	@RequestMapping("/indexPage")
	public String indexPage(Model model) {
		
		// 투어 날짜가  오늘 날짜를 지난 경우 투어 완료로 변경
		mainContentService.compareToCurrentDate();
		
		return "indexPage";
	}
	
	@RequestMapping("/kindOfLocalPage")
	public String kindOfLocalPage(TourBasicVo param, Model model) {

		
		//이달의 투어왕 3명 추출
		ArrayList<JinSunMiVo> mainJinsunmiInfoList = mainContentService.getJinSunMi(param);

		//지역이름보내기
		Location_CategoryBasicVo mainKindOfLocalPageLocation_name = mainContentService.getLocalName(param);
		
		//지역별페이지 게시물List들 가져오기
		ArrayList<Guide_Avg_ScoreVo> mainKindOfLocalPageContentLists = mainContentService.getLocalPageContentLists(param);
		
		System.out.println(mainKindOfLocalPageContentLists.size());
		
		//jsp로 보냄
		
		model.addAttribute("mainJinsunmiInfoList", mainJinsunmiInfoList);
		model.addAttribute("mainKindOfLocalPageLocation_name", mainKindOfLocalPageLocation_name);
		model.addAttribute("mainKindOfLocalPageContentLists", mainKindOfLocalPageContentLists);
		
		return "kindOfLocalPage";
	}
	
	
	
	@RequestMapping("/tourEnrollPage")
	public String tourEnrollPage(HttpSession session, Model model) {
		//session에서 글쓴이의 member_idx추출
		SessionUserDataVo mainSessionData = (SessionUserDataVo) session.getAttribute("memberSession");
		int mainSessionIdx = mainSessionData.getMember_idx();
				
		//투어등록페이지에서 가이드정보가져오기
		MemberBasicVo mainTourEnrollMemberInfo = mainContentService.getMemberInfo(mainSessionIdx);
				
		model.addAttribute("mainTourEnrollMemberInfo", mainTourEnrollMemberInfo);
				
		return "tourEnrollPage";
	}
	
	
	
	@RequestMapping("/tourInsert")
	public String tourInsert(TourBasicVo param, MultipartFile[] files, HttpSession session) {
		
		
		//파일 저장 로직 시작....
		ArrayList<UploadFileVo> fileList = new ArrayList<UploadFileVo>();
			
		//upload 파일 저장 class
		UploadFiles uploadFile = new UploadFiles();
		
		ArrayList<String> linkList = uploadFile.uploadFileLinkName(files);
				
		//이미지파일 tourBasicVo에 넣기
			if(linkList.size()==1) {
				param.setTour_photo1(linkList.get(0));
			} else if(linkList.size()==2) {
				param.setTour_photo1(linkList.get(0));
				param.setTour_photo2(linkList.get(1));
			} else if(linkList.size()==3) {
				param.setTour_photo1(linkList.get(0));
				param.setTour_photo2(linkList.get(1));
				param.setTour_photo3(linkList.get(2));
			} else if(linkList.size()==4) {
				param.setTour_photo1(linkList.get(0));
				param.setTour_photo2(linkList.get(1));
				param.setTour_photo3(linkList.get(2));
				param.setTour_photo4(linkList.get(3));
			} else if(linkList.size()==5) {
				param.setTour_photo1(linkList.get(0));
				param.setTour_photo2(linkList.get(1));
				param.setTour_photo3(linkList.get(2));
				param.setTour_photo4(linkList.get(3));
				param.setTour_photo5(linkList.get(4));
			}
			
		
		//투어테이블에등록
		mainContentService.insertTourEnroll(param);
		
		return "redirect:/kindOfLocalPage?location_idx="+param.getLocation_idx();
	}
	
	
	@RequestMapping("/tourGuideContentPage")
	public String tourGuideContentPage(TourBasicVo param, Model model, HttpSession session) {
		
		//해당게시물 tour정보+가이드정보 보내기
		MemberTourJoinVo mainTourContentData = mainContentService.getGuideContent(param);
		TourBasicVo mainTourInfo = mainContentService.getTourInfo(param.getTour_idx());
		
		String mainBookingIsAble = "nonexist";
		
		
		//현재 투어idx로 예약한 사람의 리스트를 가져온다
		//현재 세션정보가 신청자에 있는지 확인 하고 있을경우 예약을 불가하게 만든다
		SessionUserDataVo userSession = (SessionUserDataVo) session.getAttribute("memberSession");
		ArrayList<ReservationBasicVo> tourPartyList = mainContentService.checkUserBooking(param);
		
		for(ReservationBasicVo re : tourPartyList) {
			if(re.getMember_idx() == userSession.getMember_idx()) {
				mainBookingIsAble = "exist";
			}
		}
		
		System.out.println(mainBookingIsAble);
		
		model.addAttribute("mainTourInfo",mainTourInfo);
		model.addAttribute("mainTourContentData", mainTourContentData);
		model.addAttribute("mainBookingIsAble", mainBookingIsAble);
		
		return "tourGuideContentPage";
	}
	
	
	
	
	@RequestMapping("/tourContentUpdatePage")
	public String tourContentUpdatePage(TourBasicVo param, Model model) {
		
		//수정할 tour정보와 가이드정보 가져오기
		MemberTourJoinVo mainTourContentUpdateData = mainContentService.getGuideContent(param);
		
		model.addAttribute("mainTourContentUpdateData", mainTourContentUpdateData);
		
		return "tourContentUpdatePage";
	}
	
	
	
	@RequestMapping("/tourContentUpdateAction")
	public String tourContentUpdateAction(TourBasicVo param, MultipartFile[] files) {
		
		//파일 수정  로직 시작....
				ArrayList<UploadFileVo> fileList = new ArrayList<UploadFileVo>();
					
				//upload 파일 저장 class
				UploadFiles uploadFile = new UploadFiles();
				
				ArrayList<String> linkList = uploadFile.uploadFileLinkName(files);
						
				//이미지파일 tourBasicVo에 넣기
					if(linkList.size()==1) {
						param.setTour_photo1(linkList.get(0));
					} else if(linkList.size()==2) {
						param.setTour_photo1(linkList.get(0));
						param.setTour_photo2(linkList.get(1));
					} else if(linkList.size()==3) {
						param.setTour_photo1(linkList.get(0));
						param.setTour_photo2(linkList.get(1));
						param.setTour_photo3(linkList.get(2));
					} else if(linkList.size()==4) {
						param.setTour_photo1(linkList.get(0));
						param.setTour_photo2(linkList.get(1));
						param.setTour_photo3(linkList.get(2));
						param.setTour_photo4(linkList.get(3));
					} else if(linkList.size()==5) {
						param.setTour_photo1(linkList.get(0));
						param.setTour_photo2(linkList.get(1));
						param.setTour_photo3(linkList.get(2));
						param.setTour_photo4(linkList.get(3));
						param.setTour_photo5(linkList.get(4));
					}
		
		
		//게시물수정
		mainContentService.updateTourContent(param);
		
		return "redirect:/tourGuideContentPage?tour_idx="+param.getTour_idx();
	}
	
	
	
	@RequestMapping("/tourDeleteAction")
	public String tourDeleteAction(TourBasicVo param) {
		
		TourBasicVo tourInfo = mainContentService.getTourInfo(param.getTour_idx());
		//투어게시글삭제
		mainContentService.deleteTourContent(tourInfo);
		//location_idx를 가져와서 지역별페이지로 이동시키기
		
		
		
		return "redirect:/kindOfLocalPage?location_idx="+tourInfo.getLocation_idx();
	}
	
	@RequestMapping("/tourReservationPage")
	public String tourReservationPage(TourBasicVo param, Model model, HttpSession session) {
		//예약할 투어게시물 정보 가져오기
		MemberTourJoinVo mainTourDataForReservation = mainContentService.getGuideContent(param);
		
		//투어예약자 member정보 가져오기-->session에서추출
		SessionUserDataVo mainSessionData = (SessionUserDataVo) session.getAttribute("memberSession");
		int mainSessionIdx = mainSessionData.getMember_idx();
		
		MemberBasicVo mainMemberDataForReservation = mainContentService.getMemberInfo(mainSessionIdx);
		
		model.addAttribute("mainTourDataForReservation", mainTourDataForReservation);
		model.addAttribute("mainMemberDataForReservation", mainMemberDataForReservation);
		
		return "tourReservationPage";
	}

	@RequestMapping("/reservationInsertAction")
	public String reservationInsertAction(ReservationBasicVo param) {
		//투어예약테이블에등록하기
		mainContentService.insertReservation(param);
		
//		//투어게시글로다시돌아가기위해 tour_idx를 추출하여 파라미터로넘김
//		TourBasicVo mainReturnTourContent = mainContentService.getTourInfo(param.getTour_idx());
		
		return "redirect:/tourGuideContentPage?tour_idx="+param.getTour_idx();
	}
	
	@RequestMapping("/jinSunMiPage")
	public String jinSunMiPage(TourBasicVo param, Model model) {
		//진선미 member정보가져오기
		int member_idx = param.getMember_idx();
		MemberBasicVo mainJinsunmiPageMemberInfo = mainContentService.getMemberInfo(member_idx);
		//진선미의 tour정보가져오기
		ArrayList<TourBasicVo> mainJinsunmiPageTourInfo = mainContentService.getTourList(param);
		
		model.addAttribute("mainJinsunmiPageMemberInfo", mainJinsunmiPageMemberInfo);
		model.addAttribute("mainJinsunmiPageTourInfo", mainJinsunmiPageTourInfo);
		
		return "jinSunMiPage";
	}
	
	
	

	
	
}