
package com.gf.guideforyou.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gf.guideforyou.service.CustomerMypageService;
import com.gf.guideforyou.vo.Customer_EvaluationBasicVo;
import com.gf.guideforyou.vo.Guide_EvaluationBasicVo;
import com.gf.guideforyou.vo.MemberBasicVo;
import com.gf.guideforyou.vo.MemberTourCustomerJoin;
import com.gf.guideforyou.vo.MemberTourGuideJoin;
import com.gf.guideforyou.vo.MemberTourJoinVo;
import com.gf.guideforyou.vo.ReservationBasicVo;
import com.gf.guideforyou.vo.ReservationCGMemberVo;
import com.gf.guideforyou.vo.ReservationMemberTourJoinVo;
import com.gf.guideforyou.vo.SessionUserDataVo;
import com.gf.guideforyou.vo.TourBasicVo;


//컨트롤러 class를 추가할 경우 Customer를 써주기
//포워딩 하는 변수에 customer 적기 (소문자)

@Controller
public class CustomerMypageController {
	
	@Autowired
	private CustomerMypageService customerMypageService;
	
	
	
	//게스트 섹터 신청 투어 예약 확인 페이지
	@RequestMapping("/customerReservationListPage")
	public String customerReservationListPage(HttpSession session, Model model) {
		
		//세션에서 member_idx추출
		SessionUserDataVo sessionData = (SessionUserDataVo) session.getAttribute("memberSession");
		int member_idx= sessionData.getMember_idx();
		
		//member_idx를 넣은 memberVo 만듦
		MemberBasicVo CustomerEmptyMemberVo = new MemberBasicVo();
		CustomerEmptyMemberVo.setMember_idx(member_idx);
		
		//예약리스트 가져옴
		ArrayList<ReservationMemberTourJoinVo> customerReservationList = customerMypageService.customerGetReservationList(CustomerEmptyMemberVo);
		
		model.addAttribute("customerReservationList", customerReservationList);
		 
		return "customerReservationListPage";
	}
	

	//게스트 섹터 예약신청서보기 페이지
	@RequestMapping("/customerWatchTourReservationFormPage")
	public String customerWatchTourReservationFormPage(ReservationBasicVo param, Model model) {
		
		ReservationCGMemberVo customerRData = customerMypageService.watchCustomerReservationInfo(param);
		
		System.out.println(customerRData.getTourBasicVo().getTour_tourdate());
		model.addAttribute("customerRData", customerRData);
		
		return "customerWatchTourReservationFormPage";
	}
	
	//게스트 섹터 예약신청서수정 페이지
	@RequestMapping("/customerUpdateTourReservationFormPage")
	public String customerUpdateTourReservationFormPage(ReservationBasicVo param, Model model){
		
		ReservationCGMemberVo customerRData = customerMypageService.getReservationData(param);
		
		model.addAttribute("customerRData", customerRData);
		
		return "customerUpdateTourReservationFormPage";	
	}
	
	@RequestMapping("/customerUpdateTourReservationFormPageAction")
	public String customerUpdateTourReservationFormPageAction(ReservationBasicVo param) {
		
		customerMypageService.updateCustomerReservationForm(param);
		
		return "redirect:customerWatchTourReservationFormPage?reservation_idx=" + param.getReservation_idx();
	}
	
	//게스트 섹터 예약신청서 취소
	@RequestMapping("/cancelReservationAction")
	public String cancelReservationAction(ReservationBasicVo param) {
		
		customerMypageService.cancelReservation(param);
		
		return "redirect:customerReservationListPage";
	}
	
		
		@RequestMapping("/customerEvaluationListPage")
		public String customerEvaluationListPage(HttpSession session,  Model model) {
			
			SessionUserDataVo sessionData = (SessionUserDataVo) session.getAttribute("memberSession");
			 
			MemberBasicVo member = new MemberBasicVo();
			member.setMember_idx(sessionData.getMember_idx());
			//내가 작성 한 리뷰
			ArrayList<MemberTourGuideJoin> customerIWriteReview =
								customerMypageService.getIWriteReview(member);
			
			//내가 받은 리뷰
			ArrayList<MemberTourCustomerJoin> customerIgotReview = 
									customerMypageService.getIGotReview(member);
			
			
			
			model.addAttribute("customerIWriteReview", customerIWriteReview);
			model.addAttribute("customerIgotReview", customerIgotReview);
			
			return "customerEvaluationListPage";
		}
		
		
		//++한솔추가
		@RequestMapping("/customerEvaluationCheckPage")
		public String customerEvaluationCheckPage(HttpSession session, Model model) {
			
			//세션에서 member_idx추출
			SessionUserDataVo sessionData = (SessionUserDataVo) session.getAttribute("memberSession");
			int member_idx= sessionData.getMember_idx();
			
			//완료되고 리뷰를 아직 작성 안한 투어list가져오기
			ArrayList<MemberTourJoinVo> customerGuideInfoTourListForWriteReview = customerMypageService.tourListForWriteReview(member_idx);
			
			System.out.println("리뷰쓸투어리스트개수="+customerGuideInfoTourListForWriteReview.size());
			
			model.addAttribute("customerGuideInfoTourListForWriteReview", customerGuideInfoTourListForWriteReview);
			
			return "customerEvaluationCheckPage";
		}
		
		//++한솔추가
		@RequestMapping("/customerEvaluationWritePage")
		public String customerEvaluationWritePage(TourBasicVo param, Model model) {
			
			//투어idx를 이용해서 리뷰쓸 투어정보가져오기
			MemberTourJoinVo customerGuideNTourInfoForWriteReviewPage = customerMypageService.getGuideInfoTourInfo(param);
					
			model.addAttribute("customerGuideNTourInfoForWriteReview", customerGuideNTourInfoForWriteReviewPage);
			
			return "customerEvaluationWritePage";
		}
		
		//++한솔추가
				@RequestMapping("/customerEvaluationWriteAction")
				public String customerEvaluationWriteAction(@RequestParam("tour_idx") int tour_idx,@RequestParam("member_idx") int member_idx,
						   @RequestParam("score") String score,@RequestParam("guide_review") String guide_review) {
					//가이드 리뷰쓴거 테이블에 insert
					
					Guide_EvaluationBasicVo guide = new Guide_EvaluationBasicVo();
					guide.setTour_idx(tour_idx);
					guide.setMember_idx(member_idx);
					double guide_score = Double.parseDouble(score);
					guide.setGuide_score(guide_score);
					guide.setGuide_review(guide_review);
					
					
					customerMypageService.insertGuideReview(guide);
					
					return "redirect:/customerEvaluationCheckPage";
				}
				
		
	
	
	
	
}