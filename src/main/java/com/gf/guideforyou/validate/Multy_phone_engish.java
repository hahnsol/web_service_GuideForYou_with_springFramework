package com.gf.guideforyou.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Multy_phone_engish {

	private String getValue;

	public Multy_phone_engish(String getValue) {
		super();
		this.getValue = getValue;
	}
	
	public String compareValue() {
		
		
		getValue = getValue.trim();
		Pattern onlyPhone = Pattern.compile("^\\d{3}-\\d{3,4}-\\d{4}$");
		Pattern onlyEnglish_Number = Pattern.compile("^[a-zA-Z0-9]*$");
		System.out.println(getValue);
		
		
		
		Matcher phoneMatcher = onlyPhone.matcher(getValue);
		Matcher engilshMatcher = onlyEnglish_Number.matcher(getValue);
		
		if(phoneMatcher.find()) {
			return "true";
		}else {
			if(engilshMatcher.find()) {
				return "true";
			}else {
				return "false";
			}
			
		}
	}
}
