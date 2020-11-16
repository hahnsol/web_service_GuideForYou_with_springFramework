package com.gf.guideforyou.vo;

public class MemberReservationJoinVo {

	private MemberBasicVo memberBasicVo;
	private ReservationBasicVo reservationBasicVo;
	
	
	public MemberReservationJoinVo() {
		super();
	}
	
	
	public MemberReservationJoinVo(MemberBasicVo memberBasicVo, ReservationBasicVo reservationBasicVo) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.reservationBasicVo = reservationBasicVo;
	}
	
	
	public MemberBasicVo getMemberBasicVo() {
		return memberBasicVo;
	}
	public void setMemberBasicVo(MemberBasicVo memberBasicVo) {
		this.memberBasicVo = memberBasicVo;
	}
	public ReservationBasicVo getReservationBasicVo() {
		return reservationBasicVo;
	}
	public void setReservationBasicVo(ReservationBasicVo reservationBasicVo) {
		this.reservationBasicVo = reservationBasicVo;
	}
	
	
}
