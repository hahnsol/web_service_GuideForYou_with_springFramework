package com.gf.guideforyou.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//숫자 유효성 검사  정규표현식
//숫자만 가능 

public class OnlyInteger {

	private String getValue;
	

	public OnlyInteger(String intValue) {
		super();
		this.getValue = intValue;
	}

	public String compareValue() {
		
		getValue = getValue.trim();
		Pattern p = Pattern.compile("^[a-zA-Z]*$");
		System.out.println(getValue);
		
		Matcher matcher = p.matcher(getValue);
		
		if(matcher.find()) {
			return "true";
		}else {
			return "false";
		}
	}


	
}
