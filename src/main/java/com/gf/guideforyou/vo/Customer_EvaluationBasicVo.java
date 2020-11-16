package com.gf.guideforyou.vo;


//basic customer evaluation Vo

public class Customer_EvaluationBasicVo {

	private int customer_idx;
	private int tour_idx;
	private int member_idx; 
	private double customer_score;
	private String customer_review;
	
	public Customer_EvaluationBasicVo() {}

	public Customer_EvaluationBasicVo(int customer_idx, int tour_idx, int member_idx, double customer_score,
			String customer_review) {

		this.customer_idx = customer_idx;
		this.tour_idx = tour_idx;
		this.member_idx = member_idx;
		this.customer_score = customer_score;
		this.customer_review = customer_review;
	}

	public int getCustomer_idx() {
		return customer_idx;
	}

	public void setCustomer_idx(int customer_idx) {
		this.customer_idx = customer_idx;
	}

	public int getTour_idx() {
		return tour_idx;
	}

	public void setTour_idx(int tour_idx) {
		this.tour_idx = tour_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public double getCustomer_score() {
		return customer_score;
	}

	public void setCustomer_score(double customer_score) {
		this.customer_score = customer_score;
	}

	public String getCustomer_review() {
		return customer_review;
	}

	public void setCustomer_review(String customer_review) {
		this.customer_review = customer_review;
	}
	
	
	
	
}
