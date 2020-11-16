package com.gf.guideforyou.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gf.guideforyou.service.GuideMypageService;
import com.gf.guideforyou.service.MainContentService;
import com.gf.guideforyou.vo.Credit_info_getReviewVo;
import com.gf.guideforyou.vo.Customer_EvaluationBasicVo;
import com.gf.guideforyou.vo.CustomersectorGetReviewVo;
import com.gf.guideforyou.vo.Guide_Avg_ScoreVo;
import com.gf.guideforyou.vo.GuidesectorGetRiviewVo;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.MemberTourCustomerJoin;
import com.gf.guideforyou.vo.MemberTourGuideJoin;
import com.gf.guideforyou.vo.MemberTourJoinVo;
import com.gf.guideforyou.vo.ReservationBasicVo;
import com.gf.guideforyou.vo.ReservationCustomerEvaluationJoinVo;
import com.gf.guideforyou.vo.ReservationMemberTourJoinVo;
import com.gf.guideforyou.vo.SessionUserDataVo;
import com.gf.guideforyou.vo.TourBasicVo;
import com.gf.guideforyou.vo.TourSumParticipateVo;




//컨트롤러 class를 추가할 경우 Guide 써주기
//포워딩 하는 변수에 guide 적기 (소문자)

@Controller
public class GuideMypageController {

	@Autowired
	private GuideMypageService guideMypageService;
	@Autowired
	private MainContentService mainContentService;  
	
	//마이페이지 입니다
	@RequestMapping("/myPage")
	public String myPage(HttpSession session, Model model) {
		
		// 투어 날짜가  오늘 날짜를 지난 경우 투어 완료로 변경
		mainContentService.compareToCurrentDate();

		
		SessionUserDataVo memberSession = (SessionUserDataVo) session.getAttribute("memberSession");
		
		MemberBasicVo guideMemberSessionInfo = guideMypageService.getSessionInfo(memberSession);
		
		model.addAttribute("guideMemberSessionInfo", guideMemberSessionInfo);
		
		return "myPage";
	}
	
	
	
	//신용정보 페이지 입니다
	@RequestMapping("/credit_infoPage")
	public String credit_infoPage(MemberBasicVo param, Model model) {
		
		//현재 프로필 주인의 멤버 정보
		MemberBasicVo guideCreditMemberInfo = guideMypageService.getMemberInfo(param);
		//현재 프로필 주인의 투어리스트 정보
		ArrayList<TourBasicVo> guideCreditTourInfo = guideMypageService.getTourListInfo(param);

		//총 가이드 평점
		double guideGuideAvgScore = guideMypageService.guideAvgScore(param);
		//총 고객 평점
		double guideCustomerAvgScore = guideMypageService.customerAvgScore(param);
		
		
		//받은 가이드리뷰
		ArrayList<GuidesectorGetRiviewVo> guideGetGuideReview = guideMypageService.getGuideReview(param);
		//받은 게스트 리뷰
		ArrayList<CustomersectorGetReviewVo> guideGetCustomerReview = guideMypageService.getCustomerReview(param);
		
		
		//프로필 멤버 정보
		model.addAttribute("guideCreditMemberInfo", guideCreditMemberInfo);
		//프로필 멤버의 투어 리스트 정보
		model.addAttribute("guideCreditTourInfo", guideCreditTourInfo);
		
		//받은 가이드 리뷰
		model.addAttribute("guideGetGuideReview", guideGetGuideReview);
		//받은 고객 리뷰
		model.addAttribute("guideGetCustomerReview", guideGetCustomerReview);
		
		//총 가이드 평점
		model.addAttribute("guideGuideAvgScore", guideGuideAvgScore);
		//총 고객 평점
		model.addAttribute("guideCustomerAvgScore", guideCustomerAvgScore);
		
		return "credit_infoPage";
	}
	
	
	
	//내게시글 페이지 입니다
	@RequestMapping("/myBoardReadingPage")
	public String myBoardReadingPage(MemberBasicVo param, Model model, HttpSession session) {
		
		SessionUserDataVo memberSession = (SessionUserDataVo) session.getAttribute("memberSession");
		
		param.setMember_idx(memberSession.getMember_idx());
		
		ArrayList<TourBasicVo> guideMypageTourList = guideMypageService.getTourListInfo(param);
		
		
		model.addAttribute("guideMypageTourList", guideMypageTourList);
		
		return "myBoardReadingPage";
	}
	
	
	
	//내투어 예약관리 페이지
	@RequestMapping("/guideReservationListPage")
	public String guideReservationListPage(MemberBasicVo param, Model model, HttpSession session) {
		
		
		SessionUserDataVo memberSession = (SessionUserDataVo) session.getAttribute("memberSession");
		param.setMember_idx(memberSession.getMember_idx());
		
		
		ArrayList<TourSumParticipateVo> guideGuideRservationListInfo = guideMypageService.getTourParticipate(param);
		
		model.addAttribute("guideGuideRservationListInfo", guideGuideRservationListInfo);
		
		return "guideReservationListPage";
	}
	
	
	//내 투어 참여한 사람확인 페이지
	@RequestMapping("/guideReservationPeaplePage")
	public String guideReservationPeaplePage(TourBasicVo param, Model model) {
			
		ArrayList<ReservationCustomerEvaluationJoinVo> guideRCE = guideMypageService.getReservationInfo(param);
		
		
		model.addAttribute("guideRCE", guideRCE);
		
		return "guideReservationPeaplePage";
	}
	
	
	//고객 예약 신청서를 보는 페이지 
	@RequestMapping("/guideTourReservationCheckPage")
	public String guideTourReservationCheckPage(ReservationBasicVo param, Model model) {
		
		
		ReservationMemberTourJoinVo guideRMTData = guideMypageService.getReservationInfo(param);
		
		model.addAttribute("guideRMTData", guideRMTData);
		
		return "guideTourReservationCheckPage";
	}

	
	
	
	
	
	//고객 투어 확정 을 받는 페이지  ajax를 이용했습니다
	@ResponseBody
	@RequestMapping("/rest_guideTourReservationYesCheckAction")
	public HashMap<String, String> rest_guideTourReservationYesCheckAction(ReservationBasicVo vo) {
		HashMap<String, String> result = new HashMap<String, String>();
		
		String confirm = guideMypageService.updateAgreeReservationInfo(vo);
		
		result.put("r", confirm);
		
		return result;
		
	}	
	
	
	
	
	//고객 투어 거절 을 받는 페이지
		@RequestMapping("/guideTourReservationNoCheckAction")
		public String guideTourReservationNCheckAction(ReservationBasicVo vo) {
			
			guideMypageService.updateDisagreeReservationInfo(vo);
			
			return "redirect:/guideReservationPeaplePage?tour_idx="+vo.getTour_idx();
		}
		
	
		//리뷰 받을 고객 리스트 페이지 입니다
		@RequestMapping("/guideWriteReviewPage")
		public String guideWriteReviewPage(HttpSession session, Model model) {
			
			SessionUserDataVo sessionData = (SessionUserDataVo) session.getAttribute("memberSession");
			MemberBasicVo member = guideMypageService.getSessionInfo(sessionData);
			
			ArrayList<MemberTourJoinVo> guideRMTJoinData = guideMypageService.getMyTourReviewInfo(member);
			model.addAttribute("guideRMTJoinData", guideRMTJoinData);
			
			
			return "guideWriteReviewPage";
		}
		
		
		
		//리뷰 작성페이지 입니다
		@RequestMapping("/guideEvaluationWritePage")
		public String guideEvaluationWritePage(Customer_EvaluationBasicVo param, Model model) {
			
			MemberTourJoinVo guideMemberTour = guideMypageService.getCustomerInfo(param);
			
			model.addAttribute("guideMemberTour", guideMemberTour);
			
			return "guideEvaluationWritePage";
		}
		
		
		//리뷰 insert 페이지
		
		@RequestMapping("/guideEvaluationWriteActionPage")
		public String guideEvaluationWriteActionPage(@RequestParam("m_idx")int member_idx, @RequestParam("t_idx")int tour_idx,
											@RequestParam("score") String score, @RequestParam("customer_review") String customer_review){
			
			Customer_EvaluationBasicVo customer = new Customer_EvaluationBasicVo();
			customer.setMember_idx(member_idx);
			customer.setTour_idx(tour_idx);
			double customer_score = Double.parseDouble(score);
			customer.setCustomer_score(customer_score);
			customer.setCustomer_review(customer_review);
			
			 guideMypageService.insertReview(customer);
			
			return "redirect:guideWriteReviewPage";
		}
		
		
		//리뷰 관리 페이지 입니다
		@RequestMapping("/guideManageReviewPage")
		public String guideManageReviewPage(HttpSession session, Model model) {
			
			SessionUserDataVo sessionData = (SessionUserDataVo) session.getAttribute("memberSession");
			MemberBasicVo member = new MemberBasicVo();
			member.setMember_idx(sessionData.getMember_idx());
			
			ArrayList<MemberTourCustomerJoin> guideMTCustomerInfo = 
							guideMypageService.getIgotReview(member);
			
			ArrayList<MemberTourGuideJoin> guideMTGuideInfo =
							guideMypageService.getIgaveReview(member);
			
			model.addAttribute("guideMTCustomerInfo", guideMTCustomerInfo);
			model.addAttribute("guideMTGuideInfo", guideMTGuideInfo);
			
			return "guideManageReviewPage";
		}
		
		
		//내가 작성한 리뷰 삭제
		@RequestMapping("guideManageCustomerReviewPageAction")
		public String guideManageCustomerReviewPageAction(Customer_EvaluationBasicVo param) {
			
			guideMypageService.deleteReview(param);
			
			return "redirect:guideManageReviewPage";
		}
		
		
		
		
}
