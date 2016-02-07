package com.exam.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.exam.dao.ExcelFileDAO;
import com.exam.dto.ExcelFileBean;
import com.exam.service.ExcelService;

public class ImportServiceImpl implements ExcelService {
	public ExcelFileDAO excelFileDAO;

	public ExcelFileDAO getExcelFileDAO() {
		return excelFileDAO;
	}

	public void setExcelFileDAO(ExcelFileDAO excelFileDAO) {
		this.excelFileDAO = excelFileDAO;
	}

	public ImportServiceImpl() {
	}

	public List<ExcelFileBean> importFile(CommonsMultipartFile multipartFile) {
		ByteArrayInputStream bis = new ByteArrayInputStream(multipartFile.getBytes());
		Workbook workbook=null;
		List<ExcelFileBean> questions = new ArrayList<ExcelFileBean>();
		try {
			if (multipartFile.getOriginalFilename().endsWith("xls")) {
				workbook = new HSSFWorkbook(bis);
			} else if (multipartFile.getOriginalFilename()
					.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(bis);
			} else {
				throw new IllegalArgumentException(
						"Received file does not have a standard excel extension.");
			}
			// Get first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);
			ExcelFileBean excelFileBean = null;
			for (Row row : sheet) {
				System.out.println(" svsdfs "+row.getCell(0));
				if(row.getCell(1)!=null){
				excelFileBean = new ExcelFileBean();
					excelFileBean.setQuestion(row.getCell(0)
							.getStringCellValue());
					excelFileBean.setOption_1(row.getCell(1)
							.getStringCellValue());
					excelFileBean.setOption_2(row.getCell(2)
							.getStringCellValue());
					excelFileBean.setOption_3(row.getCell(3)
							.getStringCellValue());
					excelFileBean.setOption_4(row.getCell(4)
							.getStringCellValue());
					excelFileBean
							.setAnswer(row.getCell(5).getStringCellValue());
					excelFileBean.setDescriptions(row.getCell(6)
							.getStringCellValue());
					questions.add(excelFileBean);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		//excelFileDAO.insertExcelData(questions);
		return questions;
	}

	public List<ExcelFileBean> getQuestions(String examType) {
		
		return excelFileDAO.getQuestionsDetails(examType);
	}
	
	


public List<ExcelFileBean> subDetails(String ans) {
	// TODO Auto-generated method stub
	return excelFileDAO.submitedDetails(ans); 
}

}
