package com.exam.dao;

import java.util.List;

import com.exam.dto.ExcelFileBean;

public interface ExcelFileDAO {

	public int[] insertExcelData(List<ExcelFileBean> excelFileBeans);
	
	public List<ExcelFileBean> getQuestionsDetails(String examType);
	
	public List<ExcelFileBean> submitedDetails(String examType);

}
