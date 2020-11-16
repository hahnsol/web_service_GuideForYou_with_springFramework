package com.gf.guideforyou.vo;

import java.util.ArrayList;

//유기조

//고객에게 리뷰 주기 페이지에서 활용할때
//세션에서 member_idx 가져온다 그걸로 tour 리스트를 가져오고  그것을 for문으로 돌린다
//tour_idx에 참가한 사람들의 reservation 리스트를 가져오고 for문을 또 돌려서  그 참여자들의  member정보를 가져온다 
// reservation 정보와 member정보를 넣고 tour를 넣어준다


//나효수

//신청투어예약확인 페이지  
//세션 member 정보를 통해서 reservation 테이블에 있는 내 예약 정보 리스트를 가져온다
//가져온 리스트들의 각각의 투어 정보를 가져오고 그 투어 정보에 있는 가이드 member정보를 가져와서 vo에 담는다  


//내예약신청서 페이지
//신청투어예약확인 페이지  에서 넘겨준  reservation_idx를 받아서 reservation 테이블에서 예약신청서를 받아온다
//받아온 reservation 정보에 있는 member_idx로 자신의 member 정보를 가져오고 tour_idx 투어 정보를 가져와서 vo에 담는단

//예약신청서 수정 페이지도 위와 동일

//가이드에게 리뷰주기 페이지
//세션에서 member정보를 가져온다
//가져온 내 정보로 reservation 리스트를 가져온다  가져온 리스트에서 tour_idx를 이용 하여 내가 참여한 투어 리스트를 가져온다
//단 리뷰작성은 완료된 투어 일경우 만 가져아야 함으로 sql문을 만들어서 완료된 것을 가져와도되고  아닐경우 server에서 작업한다
//완료된 투어에 있는 가이드의 member_idx를 이용하여 가이드 정보를 가죠와서 vo에 담는다

public class ReservationMemberTourJoinVo {

	private ReservationBasicVo reservationBasicVo;
	private MemberBasicVo memberBasicVo;
	private TourBasicVo tourBasicVo;
	
	public ReservationMemberTourJoinVo() {
		super();
	}
	
	public ReservationMemberTourJoinVo(ReservationBasicVo reservationBasicVo, MemberBasicVo memberBasicVo,
			TourBasicVo tourBasicVo) {
		super();
		this.reservationBasicVo = reservationBasicVo;
		this.memberBasicVo = memberBasicVo;
		this.tourBasicVo = tourBasicVo;
	}
	
	public ReservationBasicVo getReservationBasicVo() {
		return reservationBasicVo;
	}
	public void setReservationBasicVo(ReservationBasicVo reservationBasicVo) {
		this.reservationBasicVo = reservationBasicVo;
	}
	public MemberBasicVo getMemberBasicVo() {
		return memberBasicVo;
	}
	public void setMemberBasicVo(MemberBasicVo memberBasicVo) {
		this.memberBasicVo = memberBasicVo;
	}
	public TourBasicVo getTourBasicVo() {
		return tourBasicVo;
	}
	public void setTourBasicVo(TourBasicVo tourBasicVo) {
		this.tourBasicVo = tourBasicVo;
	}
	
	
	
	
}
