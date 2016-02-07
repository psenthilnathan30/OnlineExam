package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.ExcelFileBean;
import com.exam.service.ExcelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ExcelController {
	@Autowired
	ExcelService importService;
	
	
    public ExcelService getImportService() {
		return importService;
	}


	public void setImportService(ExcelService importService) {
		this.importService = importService;
	}


	@RequestMapping(method = RequestMethod.POST,value="uploadFile.do")
    public @ResponseBody String upload(@RequestParam("file") CommonsMultipartFile multipartFile) {
		List<ExcelFileBean> questions= importService.importFile(multipartFile);
      //  modal.setViewName("uploadQuestions");
        //modal.addObject("message","File has been uploaded sucessfully");
		 //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue=null;
        try {
			jsonValue=objectMapper.writeValueAsString(questions);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return jsonValue;
    }
	
	@RequestMapping(method = RequestMethod.GET,value="onlineExam.htm")
    public ModelAndView getQuestionDetails(String examType,ModelAndView modal) {
        modal.setViewName("onlineExam");
        modal.addObject("questionsDetails",importService.getQuestions("1"));
        return modal;
    }
	
	@RequestMapping(method = RequestMethod.POST,value="validate.do")
    public ModelAndView SubmitQuestionDetails(String answer,ModelAndView modal) 
	{
		System.out.println("check===");
	
		modal.setViewName("submitted");
        modal.addObject("submittedquestion",importService.subDetails("1"));
        return modal;
	
	}

}