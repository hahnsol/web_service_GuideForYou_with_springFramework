package com.gf.guideforyou.validate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BirthCheck {

	private String getValue;

	public BirthCheck(String getValue) {
		super();
		this.getValue = getValue;
	}

	public String compareDate() {
		
		Date today = new Date();
		//현재 년도를 구해서 입력한 생년월일이 성인인지 판별
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int accessYear = currentYear - 18;// 만 19세만 가능
		System.out.println(accessYear);
		String getUserBirthYear = getValue.substring(0,4);
		int userBirthYear = Integer.parseInt(getUserBirthYear);
		System.out.println(userBirthYear);
		System.out.println(userBirthYear-18);
		
		
		if(userBirthYear-18 <accessYear) {
			return "true";
		}else {
			return "false";
		}

	}
	
}
