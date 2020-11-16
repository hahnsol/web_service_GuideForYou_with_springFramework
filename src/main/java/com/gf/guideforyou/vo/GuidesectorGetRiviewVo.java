package com.gf.guideforyou.vo;

import java.util.ArrayList;


//i get review as guide

public class GuidesectorGetRiviewVo {

	private TourBasicVo tourBasicVo;
	private Guide_EvaluationBasicVo guide_EvaluationBasicVo;
	private MemberBasicVo memberBasicVo;
	
	
	public GuidesectorGetRiviewVo() {
		super();
	}
	
	
	public GuidesectorGetRiviewVo(TourBasicVo tourBasicVo, Guide_EvaluationBasicVo guide_EvaluationBasicVo,
			MemberBasicVo memberBasicVo) {
		super();
		this.tourBasicVo = tourBasicVo;
		this.guide_EvaluationBasicVo = guide_EvaluationBasicVo;
		this.memberBasicVo = memberBasicVo;
	}
	
	
	public TourBasicVo getTourBasicVo() {
		return tourBasicVo;
	}
	public void setTourBasicVo(TourBasicVo tourBasicVo) {
		this.tourBasicVo = tourBasicVo;
	}
	public Guide_EvaluationBasicVo getGuide_EvaluationBasicVo() {
		return guide_EvaluationBasicVo;
	}
	public void setGuide_EvaluationBasicVo(Guide_EvaluationBasicVo guide_EvaluationBasicVo) {
		this.guide_EvaluationBasicVo = guide_EvaluationBasicVo;
	}
	public MemberBasicVo getMemberBasicVo() {
		return memberBasicVo;
	}
	public void setMemberBasicVo(MemberBasicVo memberBasicVo) {
		this.memberBasicVo = memberBasicVo;
	}
	
	
	
	
}
