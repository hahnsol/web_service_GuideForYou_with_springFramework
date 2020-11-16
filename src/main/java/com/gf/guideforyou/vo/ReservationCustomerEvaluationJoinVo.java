package com.gf.guideforyou.vo;

//추어신청자 페이지에서 활용



public class ReservationCustomerEvaluationJoinVo {

	private ReservationBasicVo reservationBasicVo;
	private MemberBasicVo memberBasicVo;
	private double sumCustomerScore;
	
	
	public ReservationCustomerEvaluationJoinVo() {
		super();
	}
	
	
	public ReservationCustomerEvaluationJoinVo(ReservationBasicVo reservationBasicVo, MemberBasicVo memberBasicVo,
			double sumCustomerScore) {
		super();
		this.reservationBasicVo = reservationBasicVo;
		this.memberBasicVo = memberBasicVo;
		this.sumCustomerScore = sumCustomerScore;
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
	public double getSumCustomerScore() {
		return sumCustomerScore;
	}
	public void setSumCustomerScore(double sumCustomerScore) {
		this.sumCustomerScore = sumCustomerScore;
	}
	
	
}
