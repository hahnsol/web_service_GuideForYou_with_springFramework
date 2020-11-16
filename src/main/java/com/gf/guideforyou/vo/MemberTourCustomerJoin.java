package com.gf.guideforyou.vo;

public class MemberTourCustomerJoin {

	private MemberBasicVo memberBasicVo;
	private TourBasicVo tourBasicVo;
	private Customer_EvaluationBasicVo customer_EvaluationBasicVo;
	
	
	public MemberTourCustomerJoin() {
		super();
	}
	
	
	public MemberTourCustomerJoin(MemberBasicVo memberBasicVo, TourBasicVo tourBasicVo,
			Customer_EvaluationBasicVo customer_EvaluationBasicVo) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.tourBasicVo = tourBasicVo;
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
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
	public Customer_EvaluationBasicVo getCustomer_EvaluationBasicVo() {
		return customer_EvaluationBasicVo;
	}
	public void setCustomer_EvaluationBasicVo(Customer_EvaluationBasicVo customer_EvaluationBasicVo) {
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
	}
	
	
	
	
}
