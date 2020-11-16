package com.gf.guideforyou.service;

import java.util.ArrayList;

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

public interface GuideMypageService {

	
	public String updateAgreeReservationInfo(ReservationBasicVo vo);
		
	public void updateDisagreeReservationInfo(ReservationBasicVo vo);
	
	public void insertReview(Customer_EvaluationBasicVo vo);
	
	public MemberTourJoinVo getCustomerInfo(Customer_EvaluationBasicVo vo);
	
	public MemberBasicVo getMemberInfo(MemberBasicVo vo);
	
	public MemberBasicVo getSessionInfo(SessionUserDataVo vo);
	
	public ArrayList<ReservationCustomerEvaluationJoinVo> getReservationInfo(TourBasicVo vo);
	
	public ArrayList<TourBasicVo> getTourListInfo(MemberBasicVo vo);
	
	public ReservationMemberTourJoinVo getReservationInfo(ReservationBasicVo vo);
	
	public ArrayList<MemberTourJoinVo> getMyTourReviewInfo(MemberBasicVo vo);
	
	//가이드 총 평점
	public Double guideAvgScore(MemberBasicVo vo);
	//고객 총 평점
	public Double customerAvgScore(MemberBasicVo vo);
	
	//받은 가이드 리뷰
	public ArrayList<CustomersectorGetReviewVo> getCustomerReview(MemberBasicVo vo);
	
	//받은 고객 리뷰
	public ArrayList<GuidesectorGetRiviewVo> getGuideReview(MemberBasicVo vo);
		
	//내투어예약관리
	public ArrayList<TourSumParticipateVo> getTourParticipate(MemberBasicVo vo);
	
	public ArrayList<MemberTourCustomerJoin> getIgotReview(MemberBasicVo vo);
	
	public ArrayList<MemberTourGuideJoin> getIgaveReview(MemberBasicVo vo);
	
	public void deleteReview(Customer_EvaluationBasicVo vo);
	
}
