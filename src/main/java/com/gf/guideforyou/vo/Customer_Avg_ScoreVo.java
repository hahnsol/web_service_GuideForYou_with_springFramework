package com.gf.guideforyou.vo;


// 투어 신청자 페이지에서 사용 
//고객 총 평점 구하는 vo
// 투어 정보를 가져온 다음 reservation에서 참여자 정보를 모으고 그 참여자들의 멤버정보를 가져옴 
//다음 페이지로 reservation_idx를 넘겨줌  ReservationMemberTourJoinVo
public class Customer_Avg_ScoreVo {

	private MemberBasicVo memberBasicVo;
	private ReservationBasicVo reservationBasicVo;
	private double customerAvgScore;
	
	
	public Customer_Avg_ScoreVo() {
		super();
	}
	
	
	public Customer_Avg_ScoreVo(MemberBasicVo memberBasicVo, ReservationBasicVo reservationBasicVo,double customerAvgScore) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.reservationBasicVo = reservationBasicVo;
		this.customerAvgScore = customerAvgScore;
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
	public double getCustomerAvgScore() {
		return customerAvgScore;
	}
	public void setCustomerAvgScore(double customerAvgScore) {
		this.customerAvgScore = customerAvgScore;
	}
	
	
}
