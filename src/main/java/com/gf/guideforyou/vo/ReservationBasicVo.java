package com.gf.guideforyou.vo;

public class ReservationBasicVo {
	
	private int reservation_idx;
	private int tour_idx;
	private int member_idx; 
	private String reservation_call;
	private int reservation_participate;
	private String reservation_wish;
	private String reservation_confirm;
	private String reservation_tour_cancle;
	private String reservation_booking_date;
	
	public ReservationBasicVo() {}
	
	public ReservationBasicVo(int reservation_idx, int tour_idx, int member_idx, String reservation_call,
			int reservation_participate, String reservation_wish, String reservation_confirm,
			String reservation_tour_cancle, String reservation_booking_date) {
		
		this.reservation_idx = reservation_idx;
		this.tour_idx = tour_idx;
		this.member_idx = member_idx;
		this.reservation_call = reservation_call;
		this.reservation_participate = reservation_participate;
		this.reservation_wish = reservation_wish;
		this.reservation_confirm = reservation_confirm;
		this.reservation_tour_cancle = reservation_tour_cancle;
		this.reservation_booking_date = reservation_booking_date;
	}
	public int getReservation_idx() {
		return reservation_idx;
	}
	public void setReservation_idx(int reservation_idx) {
		this.reservation_idx = reservation_idx;
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
	public String getReservation_call() {
		return reservation_call;
	}
	public void setReservation_call(String reservation_call) {
		this.reservation_call = reservation_call;
	}
	public int getReservation_participate() {
		return reservation_participate;
	}
	public void setReservation_participate(int reservation_participate) {
		this.reservation_participate = reservation_participate;
	}
	public String getReservation_wish() {
		return reservation_wish;
	}
	public void setReservation_wish(String reservation_wish) {
		this.reservation_wish = reservation_wish;
	}
	public String getReservation_confirm() {
		return reservation_confirm;
	}
	public void setReservation_confirm(String reservation_confirm) {
		this.reservation_confirm = reservation_confirm;
	}
	public String getReservation_tour_cancle() {
		return reservation_tour_cancle;
	}
	public void setReservation_tour_cancle(String reservation_tour_cancle) {
		this.reservation_tour_cancle = reservation_tour_cancle;
	}
	public String getReservation_booking_date() {
		return reservation_booking_date;
	}
	public void setReservation_booking_date(String reservation_booking_date) {
		this.reservation_booking_date = reservation_booking_date;
	}
	
	

}
