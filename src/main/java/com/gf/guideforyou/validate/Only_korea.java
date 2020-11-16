package com.gf.guideforyou.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Only_korea {

	private String getValue;
	
	public Only_korea(String getValue) {
		super();
		this.getValue = getValue;
	}


	public String compareValue() {
		
		getValue = getValue.trim();
		String pattern = "^[a-zA-Z]*$";
		System.out.println(getValue);
		
		boolean i = Pattern.matches(pattern, getValue);
		
		if(i == true) {
			return "true";
		}else {
			return "false";
		}
		


	}
}
