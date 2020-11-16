package com.gf.guideforyou.vo;

import java.util.ArrayList;

public class Credit_info_getReviewVo {

	private ArrayList<CustomersectorGetReviewVo> customersectorGetReviewVos;
	private ArrayList<GuidesectorGetRiviewVo> guidesectorGetRiviewVos;
	
	
	public Credit_info_getReviewVo() {
		super();
	}
	
	
	public Credit_info_getReviewVo(ArrayList<CustomersectorGetReviewVo> customersectorGetReviewVos,
			ArrayList<GuidesectorGetRiviewVo> guidesectorGetRiviewVos) {
		super();
		this.customersectorGetReviewVos = customersectorGetReviewVos;
		this.guidesectorGetRiviewVos = guidesectorGetRiviewVos;
	}
	
	
	public ArrayList<CustomersectorGetReviewVo> getCustomersectorGetReviewVos() {
		return customersectorGetReviewVos;
	}
	public void setCustomersectorGetReviewVos(ArrayList<CustomersectorGetReviewVo> customersectorGetReviewVos) {
		this.customersectorGetReviewVos = customersectorGetReviewVos;
	}
	public ArrayList<GuidesectorGetRiviewVo> getGuidesectorGetRiviewVos() {
		return guidesectorGetRiviewVos;
	}
	public void setGuidesectorGetRiviewVos(ArrayList<GuidesectorGetRiviewVo> guidesectorGetRiviewVos) {
		this.guidesectorGetRiviewVos = guidesectorGetRiviewVos;
	}
	
	
	
}
