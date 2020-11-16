package com.gf.guideforyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//송하선  controller
@Controller
public class QuestionBoardController {

	@RequestMapping("/questionPage")
	public String questionPage() {
		return "questionPage";
	}
	
	@RequestMapping("/answerPage")
	public String answerPage() {
		return "answerPage";
	}
}
