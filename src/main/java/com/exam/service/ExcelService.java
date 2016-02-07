package com.exam.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.exam.dto.ExcelFileBean;

public interface ExcelService {

    public List<ExcelFileBean> importFile(CommonsMultipartFile multipartFile);
    public List<ExcelFileBean> getQuestions(String examType);
    public List<ExcelFileBean> subDetails(String examType);
}