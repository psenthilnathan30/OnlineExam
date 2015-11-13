package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.FileBean;
import com.exam.service.ExcelService;

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
    public ModelAndView upload(FileBean uploadItem, ModelAndView modal) {
        importService.importFile(uploadItem);
        modal.setViewName("uploadQuestions");
        modal.addObject("message","File has been uploaded sucessfully");
        return modal;
    }
	
	@RequestMapping(method = RequestMethod.GET,value="onlineExam.htm")
    public ModelAndView getQuestionDetails(String examType,ModelAndView modal) {
        modal.setViewName("onlineExam");
        modal.addObject("questionsDetails",importService.getQuestions("1"));
        return modal;
    }

}