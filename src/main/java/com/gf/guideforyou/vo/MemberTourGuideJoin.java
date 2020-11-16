package com.gf.guideforyou.vo;

public class MemberTourGuideJoin {

	private MemberBasicVo memberBasicVo;
	private TourBasicVo tourBasicVo;
	private Guide_EvaluationBasicVo guide_EvaluationBasicVo;
	
	
	public MemberTourGuideJoin() {
		super();
	}
	
	
	public MemberTourGuideJoin(MemberBasicVo memberBasicVo, TourBasicVo tourBasicVo,
			Guide_EvaluationBasicVo guide_EvaluationBasicVo) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.tourBasicVo = tourBasicVo;
		this.guide_EvaluationBasicVo = guide_EvaluationBasicVo;
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
	public Guide_EvaluationBasicVo getGuide_EvaluationBasicVo() {
		return guide_EvaluationBasicVo;
	}
	public void setGuide_EvaluationBasicVo(Guide_EvaluationBasicVo guide_EvaluationBasicVo) {
		this.guide_EvaluationBasicVo = guide_EvaluationBasicVo;
	}
	
	
}
