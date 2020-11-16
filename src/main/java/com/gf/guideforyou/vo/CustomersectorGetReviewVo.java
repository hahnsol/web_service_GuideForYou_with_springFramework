package com.gf.guideforyou.vo;

//나효수
//고객 리뷰 관리페이지에서 내가받은 리뷰 vo
//세션에 있는 내정보를 가져와서 customer_evaluation 테이블에 있는 내가 받은 리뷰 리스트를 가져온다
//각 리스트들에 있는 tour_idx를 이용하여 투어 정보를 가져오고  투어 정보에 있는 가이드 member_idx를 이용하여 가이드 정보를 가져와 vo에 담는다


public class CustomersectorGetReviewVo {

	private Customer_EvaluationBasicVo customer_EvaluationBasicVo;
	private TourBasicVo tourBasicVo;
	private MemberBasicVo memberBasicVo;
	
	
	public CustomersectorGetReviewVo() {
		super();
	}


	public CustomersectorGetReviewVo(Customer_EvaluationBasicVo customer_EvaluationBasicVo, TourBasicVo tourBasicVo,
			MemberBasicVo memberBasicVo) {
		super();
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
		this.tourBasicVo = tourBasicVo;
		this.memberBasicVo = memberBasicVo;
	}


	public Customer_EvaluationBasicVo getCustomer_EvaluationBasicVo() {
		return customer_EvaluationBasicVo;
	}


	public void setCustomer_EvaluationBasicVo(Customer_EvaluationBasicVo customer_EvaluationBasicVo) {
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
	}


	public TourBasicVo getTourBasicVo() {
		return tourBasicVo;
	}


	public void setTourBasicVo(TourBasicVo tourBasicVo) {
		this.tourBasicVo = tourBasicVo;
	}


	public MemberBasicVo getMemberBasicVo() {
		return memberBasicVo;
	}


	public void setMemberBasicVo(MemberBasicVo memberBasicVo) {
		this.memberBasicVo = memberBasicVo;
	}

	
	
}
