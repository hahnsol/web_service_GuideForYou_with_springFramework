package com.gf.guideforyou.vo;

public class UploadFileVo {
	private String f_idx;
	private String c_idx;
	private String f_ori_file_name;
	private String f_link_name;
	
	public UploadFileVo() {
		super();
	}

	public UploadFileVo(String f_idx, String c_idx, String f_ori_file_name, String f_link_name) {
		super();
		this.f_idx = f_idx;
		this.c_idx = c_idx;
		this.f_ori_file_name = f_ori_file_name;
		this.f_link_name = f_link_name;
	}

	public String getF_idx() {
		return f_idx;
	}

	public void setF_idx(String f_idx) {
		this.f_idx = f_idx;
	}

	public String getC_idx() {
		return c_idx;
	}

	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}

	public String getF_ori_file_name() {
		return f_ori_file_name;
	}

	public void setF_ori_file_name(String f_ori_file_name) {
		this.f_ori_file_name = f_ori_file_name;
	}

	public String getF_link_name() {
		return f_link_name;
	}

	public void setF_link_name(String f_link_name) {
		this.f_link_name = f_link_name;
	}
	
	
	
}
