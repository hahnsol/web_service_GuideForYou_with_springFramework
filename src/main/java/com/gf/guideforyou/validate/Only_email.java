package com.gf.guideforyou.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Only_email {

	private String getValue;

	public Only_email(String getValue) {
		super();
		this.getValue = getValue;
	}
	
	public String compareValue() {
		
		System.out.println(getValue);
		getValue = getValue.trim();
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		
		
		Matcher matcher = p.matcher(getValue);
		
		if(matcher.find()) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
	
}
