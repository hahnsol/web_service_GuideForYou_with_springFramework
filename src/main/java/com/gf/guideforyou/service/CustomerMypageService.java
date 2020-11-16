package com.gf.guideforyou.service;

import java.util.ArrayList;

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

public interface CustomerMypageService {

	
	//게스트 예약신청내역 가져오기
	public ArrayList<ReservationMemberTourJoinVo> customerGetReservationList(MemberBasicVo vo);
		
	//게스트 예약신청서 
	public ReservationCGMemberVo watchCustomerReservationInfo(ReservationBasicVo vo);
	
	//게스트 예약신청서 수정
	public void updateCustomerReservationForm(ReservationBasicVo vo);
	
	public ReservationCGMemberVo getReservationData(ReservationBasicVo vo);
	
	//게스트 예약신청서 취소
	public void cancelReservation(ReservationBasicVo vo);
	
	
	public ArrayList<MemberTourGuideJoin> getIWriteReview(MemberBasicVo vo);
	
	public ArrayList<MemberTourCustomerJoin> getIGotReview(MemberBasicVo vo);
	
	
	//게스트 리뷰작성할 투어리스트 가져오기  ++한솔추가
		public ArrayList<MemberTourJoinVo> tourListForWriteReview(int member_idx);
		
		//게스트 리뷰작성 ++한솔추가
		public MemberTourJoinVo getGuideInfoTourInfo(TourBasicVo vo);
		
		//게스트가 쓴 가이드리뷰테이블에 저장 ++한솔
		public void insertGuideReview(Guide_EvaluationBasicVo vo);
}
