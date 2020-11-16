package com.gf.guideforyou.vo;

public class MemberCustomerEvaluationJoinVo {

	private MemberBasicVo memberBasicVo;
	private Customer_EvaluationBasicVo customer_EvaluationBasicVo;
	
	
	public MemberCustomerEvaluationJoinVo() {
		super();
	}
	
	
	public MemberCustomerEvaluationJoinVo(MemberBasicVo memberBasicVo, Customer_EvaluationBasicVo customer_EvaluationBasicVo) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
	}
	
	
	public MemberBasicVo getMemberBasicVo() {
		return memberBasicVo;
	}
	public void setMemberBasicVo(MemberBasicVo memberBasicVo) {
		this.memberBasicVo = memberBasicVo;
	}
	public Customer_EvaluationBasicVo getCustomer_EvaluationBasicVo() {
		return customer_EvaluationBasicVo;
	}
	public void setCustomer_EvaluationBasicVo(Customer_EvaluationBasicVo customer_EvaluationBasicVo) {
		this.customer_EvaluationBasicVo = customer_EvaluationBasicVo;
	}
	
	
}
