package com.gf.guideforyou.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Only_english_number {

	private String getValue;

	public Only_english_number(String getValue) {
		super();
		this.getValue = getValue;
	}
	
	
	public String compareValue() {
		
		getValue = getValue.trim();
		Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
		System.out.println(getValue);
		
		Matcher matcher = p.matcher(getValue);
		
		if(matcher.find()) {
			return "true";
		}else {
			return "false";
		}
	}
	
}
