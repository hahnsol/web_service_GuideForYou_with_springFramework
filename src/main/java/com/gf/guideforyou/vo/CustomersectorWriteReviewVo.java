package com.gf.guideforyou.vo;

//나효수
//고객 리뷰 관리페이지에서 내가작성한 리뷰 vo
//세션에 있는 내정보를 가져와서 guide_evaluation테이블에 넣고 내가 가이드들에게 작성한 리뷰 리스트를 가져온다
//각 리스트들에 있는 tour_idx를 이용하여 투어 정보를 가져오고  투어 정보에 있는 가이드 member_idx를 이용하여 가이드 정보를 가져와 vo에 담는다

public class CustomersectorWriteReviewVo {

	private Guide_EvaluationBasicVo guide_EvaluationBasicVo;
	private TourBasicVo tourBasicVo;
	private MemberBasicVo memberBasicVo;// guide member_idx
	
	
	public CustomersectorWriteReviewVo() {
		super();
	}
	
	
	public CustomersectorWriteReviewVo(Guide_EvaluationBasicVo guide_EvaluationBasicVo, TourBasicVo tourBasicVo,
			MemberBasicVo memberBasicVo) {
		super();
		this.guide_EvaluationBasicVo = guide_EvaluationBasicVo;
		this.tourBasicVo = tourBasicVo;
		this.memberBasicVo = memberBasicVo;
	}
	
	
	public Guide_EvaluationBasicVo getGuide_EvaluationBasicVo() {
		return guide_EvaluationBasicVo;
	}
	public void setGuide_EvaluationBasicVo(Guide_EvaluationBasicVo guide_EvaluationBasicVo) {
		this.guide_EvaluationBasicVo = guide_EvaluationBasicVo;
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
