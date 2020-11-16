package com.gf.guideforyou.vo;

public class Location_CategoryBasicVo {
	private int location_idx;
	private String location_region;
	
	public Location_CategoryBasicVo() {
		super();
	}

	public Location_CategoryBasicVo(int location_idx, String location_region) {
		super();
		this.location_idx = location_idx;
		this.location_region = location_region;
	}

	public int getLocation_idx() {
		return location_idx;
	}

	public void setLocation_idx(int location_idx) {
		this.location_idx = location_idx;
	}

	public String getLocation_region() {
		return location_region;
	}

	public void setLocation_region(String location_region) {
		this.location_region = location_region;
	}
	
	
	
	
}
