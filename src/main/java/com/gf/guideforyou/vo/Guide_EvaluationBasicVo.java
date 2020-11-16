package com.gf.guideforyou.vo;

//basic guide evaluation vo


public class Guide_EvaluationBasicVo {

	private int guide_idx;
	private int tour_idx;
	private int member_idx; 
	private double guide_score;
	private String guide_review;
	
	public Guide_EvaluationBasicVo() {}
	
	public Guide_EvaluationBasicVo(int guide_idx, int tour_idx, int member_idx, double guide_score, String guide_review) {
		
		this.guide_idx = guide_idx;
		this.tour_idx = tour_idx;
		this.member_idx = member_idx;
		this.guide_score = guide_score;
		this.guide_review = guide_review;
	}
	public int getGuide_idx() {
		return guide_idx;
	}
	public void setGuide_idx(int guide_idx) {
		this.guide_idx = guide_idx;
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
	public double getGuide_score() {
		return guide_score;
	}
	public void setGuide_score(double guide_score) {
		this.guide_score = guide_score;
	}
	public String getGuide_review() {
		return guide_review;
	}
	public void setGuide_review(String guide_review) {
		this.guide_review = guide_review;
	}
	
	
}
