package com.gf.guideforyou.vo;


//한솔추가++
public class JinSunMiVo {
	private MemberBasicVo memberBasicVo;
	private TourBasicVo tourBasicVo;
	double tourAvgScore;
	
	public JinSunMiVo() {
		super();
	}

	public JinSunMiVo(MemberBasicVo memberBasicVo, TourBasicVo tourBasicVo, double tourAvgScore) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.tourBasicVo = tourBasicVo;
		this.tourAvgScore = tourAvgScore;
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

	public double getTourAvgScore() {
		return tourAvgScore;
	}

	public void setTourAvgScore(double tourAvgScore) {
		this.tourAvgScore = tourAvgScore;
	}
	
	
	
	
}
