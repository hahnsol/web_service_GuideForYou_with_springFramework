package com.gf.guideforyou.vo;

public class TourSumParticipateVo {
	//guide tour_list page's total participate info 
	private TourBasicVo tourBasicVo;
	private int sumParticipate;
	
	public TourSumParticipateVo() {
		super();
	}
	
	public TourSumParticipateVo(TourBasicVo tourBasicVo, int sumParticipate) {
		super();
		this.tourBasicVo = tourBasicVo;
		this.sumParticipate = sumParticipate;
	}
	
	
	public TourBasicVo getTourBasicVo() {
		return tourBasicVo;
	}
	public void setTourBasicVo(TourBasicVo tourBasicVo) {
		this.tourBasicVo = tourBasicVo;
	}
	public int getSumParticipate() {
		return sumParticipate;
	}
	public void setSumParticipate(int sumParticipate) {
		this.sumParticipate = sumParticipate;
	}
	
	
}
