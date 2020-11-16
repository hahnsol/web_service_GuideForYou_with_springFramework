package com.gf.guideforyou.vo;

import java.util.ArrayList;

//가이드 리뷰 관리 페이지에서  내가 작성한 리뷰 vo
//세션에서 member_idx를 가져오고 투어 리스트를 가져온다 
//투어리스트를 for로 돌리면서 고객정보 리스트를 가져오고  고객리스트를 이중for로 돌리면서 member로 연결 시키고 투어 정보를 넣는다

public class GuidesectorWriteReviewVo {

	private TourBasicVo tourBasicVo;
	private Customer_EvaluationBasicVo customer_EvaluationBasicVo;
	private MemberBasicVo memberBasicVo;
	
	
	public GuidesectorWriteReviewVo() {
		super();
	}
	
	
	public GuidesectorWriteReviewVo(TourBasicVo tourBasicVo, Customer_EvaluationBasicVo customer_EvaluationBasicVo,
			MemberBasicVo memberBasicVo) {
		super();
		this.tourBasicVo = tourBasicVo;
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
		this.memberBasicVo = memberBasicVo;
	}
	
	
	public TourBasicVo getTourBasicVo() {
		return tourBasicVo;
	}
	public void setTourBasicVo(TourBasicVo tourBasicVo) {
		this.tourBasicVo = tourBasicVo;
	}
	public Customer_EvaluationBasicVo getCustomer_EvaluationBasicVo() {
		return customer_EvaluationBasicVo;
	}
	public void setCustomer_EvaluationBasicVo(Customer_EvaluationBasicVo customer_EvaluationBasicVo) {
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
	}
	public MemberBasicVo getMemberBasicVo() {
		return memberBasicVo;
	}
	public void setMemberBasicVo(MemberBasicVo memberBasicVo) {
		this.memberBasicVo = memberBasicVo;
	}
	
	
	
	
		
}
