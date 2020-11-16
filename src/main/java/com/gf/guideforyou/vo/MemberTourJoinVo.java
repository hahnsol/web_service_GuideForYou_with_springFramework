package com.gf.guideforyou.vo;


//한솔
//투어보기페이지
//지역별페이지에 있는 투어를 클릭 하면 tour_idx가 넘어간다
// 받은 tour_idx를 받아서 투어 정보를 가져오고 가져온 투어의 member_idx로  가이드 정보를 가져와서 vo에 담는다 
//가이드 리뷰 평점 보기 버튼이 있는데 그 버튼에 가이드 member_idx를 넘기기


public class MemberTourJoinVo {

	private MemberBasicVo memberBasicVo;
	private TourBasicVo tourBasicVo;
	
	public MemberTourJoinVo() {
		super();
	}
	
	public MemberTourJoinVo(MemberBasicVo memberBasicVo, TourBasicVo tourBasicVo) {
		super();
		this.memberBasicVo = memberBasicVo;
		this.tourBasicVo = tourBasicVo;
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
	
	
}
