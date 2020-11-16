package com.gf.guideforyou.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Only_phone {

	
	private String getValue;
	

	public Only_phone(String getValue) {
		super();
		this.getValue = getValue;
	}


	public String compareValue() {
		
		getValue = getValue.trim();
		Pattern p = Pattern.compile("^\\d{3}-\\d{3,4}-\\d{4}$");
		System.out.println(getValue);
		
		Matcher matcher = p.matcher(getValue);
		
		if(matcher.find()) {
			return "true";
		}else {
			return "false";
		}
	}
}
