package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonHandler {

	public CommonHandler() {
	}

	/*@RequestMapping(method=RequestMethod.GET,value="/onlineExam.htm")
	public String examPage(){
		
		return "onlineExam";
	}*/
	@RequestMapping(method=RequestMethod.GET,value="/index.htm")
	public String indexPage(){
		
		return "index";
	}
	@RequestMapping(method=RequestMethod.GET,value="/upload.htm")
	public String uploadPage(){
		
		return "uploadQuestions";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/issuePage.htm")
	public String myIssuePage(){
		
		return "myissues";
	}
	
}
