package com.gf.guideforyou.vo;


//기본 투어 vo입니다

public class TourBasicVo {

	private int tour_idx;
	private int member_idx;
	private int location_idx;
	private int tour_max_number;
	private String tour_vehicle;
	private String tour_tourdate;
	private String tour_tourspot;
	private String tour_intro;
	private String tour_content;
	private String tour_complete;
	private String tour_enrollment_date;
	private String tour_photo1;
	private String tour_photo2;
	private String tour_photo3;
	private String tour_photo4;
	private String tour_photo5;
	
	
	public TourBasicVo() {}
	
	public TourBasicVo(int tour_idx, int member_idx, int location_idx, int tour_max_number, String tour_vehicle,
			String tour_tourdate, String tour_tourspot, String tour_intro, String tour_content, String tour_complete,
			String tour_enrollment_date, String tour_photo1, String tour_photo2, String tour_photo3, String tour_photo4,
			String tour_photo5) {
		
		this.tour_idx = tour_idx;
		this.member_idx = member_idx;
		this.location_idx = location_idx;
		this.tour_max_number = tour_max_number;
		this.tour_vehicle = tour_vehicle;
		this.tour_tourdate = tour_tourdate;
		this.tour_tourspot = tour_tourspot;
		this.tour_intro = tour_intro;
		this.tour_content = tour_content;
		this.tour_complete = tour_complete;
		this.tour_enrollment_date = tour_enrollment_date;
		this.tour_photo1 = tour_photo1;
		this.tour_photo2 = tour_photo2;
		this.tour_photo3 = tour_photo3;
		this.tour_photo4 = tour_photo4;
		this.tour_photo5 = tour_photo5;
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

	public int getLocation_idx() {
		return location_idx;
	}

	public void setLocation_idx(int location_idx) {
		this.location_idx = location_idx;
	}

	public int getTour_max_number() {
		return tour_max_number;
	}

	public void setTour_max_number(int tour_max_number) {
		this.tour_max_number = tour_max_number;
	}

	public String getTour_vehicle() {
		return tour_vehicle;
	}

	public void setTour_vehicle(String tour_vehicle) {
		this.tour_vehicle = tour_vehicle;
	}

	public String getTour_tourdate() {
		return tour_tourdate;
	}

	public void setTour_tourdate(String tour_tourdate) {
		this.tour_tourdate = tour_tourdate;
	}

	public String getTour_tourspot() {
		return tour_tourspot;
	}

	public void setTour_tourspot(String tour_tourspot) {
		this.tour_tourspot = tour_tourspot;
	}

	public String getTour_intro() {
		return tour_intro;
	}

	public void setTour_intro(String tour_intro) {
		this.tour_intro = tour_intro;
	}

	public String getTour_content() {
		return tour_content;
	}

	public void setTour_content(String tour_content) {
		this.tour_content = tour_content;
	}

	public String getTour_complete() {
		return tour_complete;
	}

	public void setTour_complete(String tour_complete) {
		this.tour_complete = tour_complete;
	}

	public String getTour_enrollment_date() {
		return tour_enrollment_date;
	}

	public void setTour_enrollment_date(String tour_enrollment_date) {
		this.tour_enrollment_date = tour_enrollment_date;
	}

	public String getTour_photo1() {
		return tour_photo1;
	}

	public void setTour_photo1(String tour_photo1) {
		this.tour_photo1 = tour_photo1;
	}

	public String getTour_photo2() {
		return tour_photo2;
	}

	public void setTour_photo2(String tour_photo2) {
		this.tour_photo2 = tour_photo2;
	}

	public String getTour_photo3() {
		return tour_photo3;
	}

	public void setTour_photo3(String tour_photo3) {
		this.tour_photo3 = tour_photo3;
	}

	public String getTour_photo4() {
		return tour_photo4;
	}

	public void setTour_photo4(String tour_photo4) {
		this.tour_photo4 = tour_photo4;
	}

	public String getTour_photo5() {
		return tour_photo5;
	}

	public void setTour_photo5(String tour_photo5) {
		this.tour_photo5 = tour_photo5;
	}
	
	
	
	
	
}
