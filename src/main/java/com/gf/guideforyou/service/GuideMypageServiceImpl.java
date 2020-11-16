package com.gf.guideforyou.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.guideforyou.mapper.Customer_EvaluationSQLMapper;
import com.gf.guideforyou.mapper.Guide_EvaluationSQLMapper;
import com.gf.guideforyou.mapper.MemberSQLMapper;
import com.gf.guideforyou.mapper.ReservationSQLMapper;
import com.gf.guideforyou.mapper.Tour_EnrollSQLMapper;
import com.gf.guideforyou.vo.Credit_info_getReviewVo;
import com.gf.guideforyou.vo.Customer_EvaluationBasicVo;
import com.gf.guideforyou.vo.CustomersectorGetReviewVo;
import com.gf.guideforyou.vo.Guide_Avg_ScoreVo;
import com.gf.guideforyou.vo.Guide_EvaluationBasicVo;
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


@Service
public class GuideMypageServiceImpl implements GuideMypageService{

	@Autowired MemberSQLMapper memberSQLMapper;
	@Autowired Tour_EnrollSQLMapper tour_EnrollSQLMapper;
	@Autowired Customer_EvaluationSQLMapper customer_EvaluationSQLMapper;
	@Autowired Guide_EvaluationSQLMapper guide_EvaluationSQLMapper;
	@Autowired ReservationSQLMapper reservationSQLMapper;
	
	
	@Override
	public MemberBasicVo getMemberInfo(MemberBasicVo vo) {
		
		MemberBasicVo memberInfo = memberSQLMapper.selectMemberInfoByMemberIdx(vo.getMember_idx());
		
		return memberInfo;
	}


	@Override
	public ArrayList<TourBasicVo> getTourListInfo(MemberBasicVo vo) {
		
		ArrayList<TourBasicVo> tourList = tour_EnrollSQLMapper.credit_infoTourListByMemberIdx(vo);
		
		return tourList;
	}
	
	@Override
	public ArrayList<ReservationCustomerEvaluationJoinVo> getReservationInfo(TourBasicVo vo) {
		
		ArrayList<ReservationCustomerEvaluationJoinVo> reservationCustomerEvaluationList = 
													new ArrayList<ReservationCustomerEvaluationJoinVo>();
		
		ReservationBasicVo re = new ReservationBasicVo();
		re.setTour_idx(vo.getTour_idx());
		
		ArrayList<ReservationBasicVo> reservationList = reservationSQLMapper.selectReservationInfoByTourIdx(re);
		
		for(ReservationBasicVo reservation : reservationList) {
		
			MemberBasicVo member = memberSQLMapper.selectMemberInfoByMemberIdx(reservation.getMember_idx());
			String stringCustomerScore = customer_EvaluationSQLMapper.kijoselectAvg_Score(member.getMember_idx());
			double customerScore;
			
			if(stringCustomerScore == null) {
				customerScore = 0.0;
			}
			else {
				customerScore = Double.parseDouble(stringCustomerScore);
			}
			
			ReservationCustomerEvaluationJoinVo rce = 
					new ReservationCustomerEvaluationJoinVo(reservation, member, customerScore);
			
			reservationCustomerEvaluationList.add(rce);
		}
		
		return reservationCustomerEvaluationList;
	}

	
	//가이드 총 평점
	@Override
	public Double guideAvgScore(MemberBasicVo vo) {
		
		String score = guide_EvaluationSQLMapper.kijoselectAvg_Score(vo.getMember_idx());
	
		if(score == null) {
			return 0.0;
		}
		else {
			return Double.parseDouble(score) ;
		}
		
		
	}
	//고객 총 평점
	@Override
	public Double customerAvgScore(MemberBasicVo vo) {
		
		String score = customer_EvaluationSQLMapper.kijoselectAvg_Score(vo.getMember_idx());
		
		if(score == null) {
			
			return 0.0;
		}
		else {
			return Double.parseDouble(score) ;
		}
		
		
	}


	//받은 가이드 리뷰
	@Override
	public ArrayList<GuidesectorGetRiviewVo> getGuideReview(MemberBasicVo vo) {

		//내가 받은 가이드 리뷰 변수
				ArrayList<GuidesectorGetRiviewVo> guidesectorGetRiviewVos = new ArrayList<GuidesectorGetRiviewVo>();
				
		//가이드
				ArrayList<TourBasicVo> myTourList = tour_EnrollSQLMapper.credit_infoTourListByMemberIdx(vo);
				
				
				//내가 받은 가이드 리뷰
				for(TourBasicVo tour : myTourList) {
					ArrayList<Guide_EvaluationBasicVo> getGuideList = guide_EvaluationSQLMapper.selectGuideInfo(tour);
					
					
					for(Guide_EvaluationBasicVo guideList : getGuideList) {
						MemberBasicVo memberInfo = memberSQLMapper.selectMemberInfoByMemberIdx(guideList.getMember_idx());
						GuidesectorGetRiviewVo getGuide =
								new GuidesectorGetRiviewVo(tour,guideList,memberInfo);
						guidesectorGetRiviewVos.add(getGuide);
					
					}
					
				}
				
		return guidesectorGetRiviewVos;
	}



	
	//받은 고객 리뷰
	@Override
	public ArrayList<CustomersectorGetReviewVo> getCustomerReview(MemberBasicVo vo) {

		//내가 받은 고객 리뷰 변수
				ArrayList<CustomersectorGetReviewVo> customersectorGetReviewVos = new ArrayList<CustomersectorGetReviewVo>();
				
		//고객
				ArrayList<Customer_EvaluationBasicVo> customer_info =  
						customer_EvaluationSQLMapper.kijoSelectCustomerByMemberIdx(vo);
				
				
		//내가 받은 게스트 리뷰 
				for(Customer_EvaluationBasicVo customer : customer_info) {
					TourBasicVo tour = new TourBasicVo() ;
					tour.setTour_idx(customer.getTour_idx());
					
					TourBasicVo getTour = tour_EnrollSQLMapper.selectTourByTourIdx(tour);
					MemberBasicVo getMember = memberSQLMapper.selectMemberInfoByMemberIdx(getTour.getMember_idx());
					
					CustomersectorGetReviewVo getCustomer = 
							new CustomersectorGetReviewVo(customer,getTour,getMember);
					customersectorGetReviewVos.add(getCustomer);
				}
		
		return customersectorGetReviewVos;
	}


	//내  투어예약관리
	@Override
	public ArrayList<TourSumParticipateVo> getTourParticipate(MemberBasicVo vo) {

		ArrayList<TourSumParticipateVo> tourSumParticipateInfoList = new ArrayList<TourSumParticipateVo>();
		
		ArrayList<TourBasicVo> tourList = tour_EnrollSQLMapper.credit_infoTourListByMemberIdx(vo);
		
		
		for(TourBasicVo tour : tourList) {
			
			if(tour.getTour_complete().equals("n")) {
				ReservationBasicVo reservation = new ReservationBasicVo();
				reservation.setTour_idx(tour.getTour_idx());
				int totalParticipate;
				
				
				if(reservationSQLMapper.selectSumParticiateByTourIdx(reservation) == null) {
					totalParticipate = 0;
				}
				else {
					 String getParty = reservationSQLMapper.selectSumParticiateByTourIdx(reservation);
					 totalParticipate = Integer.parseInt(getParty);
				}
				 
				
				TourSumParticipateVo tourReservation = new TourSumParticipateVo(tour,totalParticipate);
				tourSumParticipateInfoList.add(tourReservation);
			}
			
			
			
		}
		
		return tourSumParticipateInfoList;
	}

	
	//세션에서 가져옵니다
	@Override
	public MemberBasicVo getSessionInfo(SessionUserDataVo vo) {

		MemberBasicVo memberInfo = memberSQLMapper.selectMemberInfoByMemberIdx(vo.getMember_idx());
		
		return memberInfo;
		
	}

	//reservation_idx 를 이용해서  예약 정보를 가져 옵니다
	@Override
	public ReservationMemberTourJoinVo getReservationInfo(ReservationBasicVo vo) {

		
		ReservationBasicVo reservationInfo = reservationSQLMapper.selectReservationInfoByReservationIdx(vo);
		MemberBasicVo memberInfo = memberSQLMapper.selectMemberInfoByMemberIdx(reservationInfo.getMember_idx());
		
		TourBasicVo tour = new TourBasicVo();
		tour.setTour_idx(reservationInfo.getTour_idx());
		TourBasicVo tourInfo = tour_EnrollSQLMapper.selectTourByTourIdx(tour);
		
		ReservationMemberTourJoinVo rmtJoinData = new ReservationMemberTourJoinVo(reservationInfo, memberInfo, tourInfo);
		
		return rmtJoinData;
	}



	@Override
	public String updateAgreeReservationInfo(ReservationBasicVo vo) {
		
		int re_idx = vo.getReservation_idx();
		ReservationBasicVo reservation = reservationSQLMapper.selectReservationInfoByReservationIdx(vo);
		TourBasicVo tour = new TourBasicVo();
		tour.setTour_idx(reservation.getTour_idx());
		
		//투어정보를 가져와서  총 투어참여  인원을 구한 값
		TourBasicVo tourInfo = tour_EnrollSQLMapper.selectTourByTourIdx(tour);
		int tourCanParticipate = tourInfo.getTour_max_number();
		
		//투어 참여 확정이 된사람들의 숫자
		
		
		String confirmNumber = reservationSQLMapper.selectSumYesParticiateByTourIdx(reservation);
		int number;
		if(confirmNumber == null) {
			number = 0;
		}else {
			number = Integer.parseInt(confirmNumber);
		}
		//신청자가 신청한 인원수
		int myParticipate = reservation.getReservation_participate();
		
		//총 투어 참여 가능 인원  > 현재 확정인원 + 신청자가 신청한 인원
		if(tourCanParticipate >= number+myParticipate) {
			reservationSQLMapper.updateReservationY(re_idx);
			return "yes";
		}
		else {
			return "no";
		}
		
		
	}

	
	
	@Override
	public void updateDisagreeReservationInfo(ReservationBasicVo vo) {
		
		int re_idx = vo.getReservation_idx();
		
		reservationSQLMapper.updateReservationN(re_idx);;
	}

	
	
	@Override
	public ArrayList<MemberTourJoinVo> getMyTourReviewInfo(MemberBasicVo vo){
		
		ArrayList<MemberTourJoinVo> MTJoin = new ArrayList<MemberTourJoinVo>();
		ArrayList<TourBasicVo> tourList = tour_EnrollSQLMapper.credit_infoTourListByMemberIdx(vo);
		
		for(TourBasicVo tour : tourList) {
		
			if(tour.getTour_complete().equals("y")) {
				
				ReservationBasicVo re = new ReservationBasicVo();
				re.setTour_idx(tour.getTour_idx());
				
				ArrayList<Customer_EvaluationBasicVo> partyCustomer = 
						customer_EvaluationSQLMapper.kijoSelectCustomerByMemberTour(re);
				
				for(Customer_EvaluationBasicVo c : partyCustomer) {
					MemberBasicVo member = memberSQLMapper.selectMemberInfoByMemberIdx(c.getMember_idx());
					MemberTourJoinVo joinData = new MemberTourJoinVo(member, tour);
					MTJoin.add(joinData);
				}
				
			}
			
		}
		
		return MTJoin;
	}
	
	
	@Override
	public MemberTourJoinVo getCustomerInfo(Customer_EvaluationBasicVo vo) {
		
		MemberBasicVo member = memberSQLMapper.selectMemberInfoByMemberIdx(vo.getMember_idx());
		TourBasicVo t = new TourBasicVo();
		t.setTour_idx(vo.getTour_idx());
		
		TourBasicVo tour = tour_EnrollSQLMapper.selectTourByTourIdx(t);
		
		MemberTourJoinVo MTJoin = new MemberTourJoinVo(member, tour);
		
		return MTJoin;
	}

	@Override
	public void insertReview(Customer_EvaluationBasicVo vo) {
		
		System.out.println(vo.getCustomer_score());
		
			customer_EvaluationSQLMapper.insertCustomerEvaluation(vo);
		
		
	}
	
	
	@Override
	public ArrayList<MemberTourCustomerJoin> getIgotReview(MemberBasicVo vo) {
		
		ArrayList<MemberTourCustomerJoin> MTCJoinVo = new ArrayList<MemberTourCustomerJoin>();
		
		TourBasicVo tour = new TourBasicVo();
		tour.setMember_idx(vo.getMember_idx());
		
		ArrayList<TourBasicVo> tourList = tour_EnrollSQLMapper.selectTourByMemberIdx(tour);
		
		for(TourBasicVo t : tourList) {
			
			if(t.getTour_complete().equals("y")) {
				Customer_EvaluationBasicVo customer = new Customer_EvaluationBasicVo();
				customer.setTour_idx(t.getTour_idx());
				
				ArrayList<Customer_EvaluationBasicVo> customerList = 
						customer_EvaluationSQLMapper.selectCustomerByTourIdx(customer);
				
				for(Customer_EvaluationBasicVo c : customerList) {
					MemberBasicVo customerMember = 
					memberSQLMapper.selectMemberInfoByMemberIdx(c.getMember_idx());
					MemberTourCustomerJoin mtc = new MemberTourCustomerJoin(customerMember, t, c);
					MTCJoinVo.add(mtc);
				}
			}
		}
		
		
		return MTCJoinVo;
	}


	@Override
	public ArrayList<MemberTourGuideJoin> getIgaveReview(MemberBasicVo vo) {

		ArrayList<MemberTourGuideJoin> MTGJoinVo = new ArrayList<MemberTourGuideJoin>();
		
		TourBasicVo tour = new TourBasicVo();
		tour.setMember_idx(vo.getMember_idx());
		
		ArrayList<TourBasicVo> tourList = tour_EnrollSQLMapper.selectTourByMemberIdx(tour);
		
		for(TourBasicVo t : tourList) {
			
			
			if(t.getTour_complete().equals("y")) {
				
				System.out.println(t.getTour_idx());
				System.out.println(t.getTour_intro());
				ArrayList<Guide_EvaluationBasicVo> guideList = 
									guide_EvaluationSQLMapper.selectGuideInfo(t);
				
				for(Guide_EvaluationBasicVo g : guideList) {
					MemberBasicVo customerMember = memberSQLMapper.selectMemberInfoByMemberIdx(g.getMember_idx());
					
					System.out.println(g.getMember_idx());
					
					MemberTourGuideJoin mtg = 
							new MemberTourGuideJoin(customerMember, t, g);
					
					MTGJoinVo.add(mtg);
				}
			}
			
		}
		
		
		return MTGJoinVo;
	}
	
	
	//내가 작성한 리뷰 삭제하는 페이지 입니다
	@Override
	public void deleteReview(Customer_EvaluationBasicVo vo) {
		
		customer_EvaluationSQLMapper.deleteReviewByCustomer_Idx(vo.getCustomer_idx());
		
	}
	
}
