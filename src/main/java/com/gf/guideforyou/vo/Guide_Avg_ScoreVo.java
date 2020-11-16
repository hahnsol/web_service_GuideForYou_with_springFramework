package com.gf.guideforyou.vo;

// 한솔
//지역별페이지
//index에서 location_idx가 들어오면 그에 맞는 투어리스트를 가져온다
//가져온 투어 리스트 에 있는 가이드 member_idx로 가이드 정보를 가져오고 
//가이드 평점을 가져오는 sql문을 이용하여 가이드 평점을 가져온다 

public class Guide_Avg_ScoreVo {

	private MemberBasicVo memberBasicVo;
	private TourBasicVo tourBasicVo;
	private double guideAvgScore;
	
	public Guide_Avg_ScoreVo() {
		super();
	}
	
	public Guide_Avg_ScoreVo(MemberBasicVo memberBasicVo, TourBasicVo tourBasicVo, double avgScore) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.tourBasicVo = tourBasicVo;
		this.guideAvgScore = avgScore;
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

	public double getGuideAvgScore() {
		return guideAvgScore;
	}

	public void setGuideAvgScore(double guideAvgScore) {
		this.guideAvgScore = guideAvgScore;
	}
	
	
	
}
