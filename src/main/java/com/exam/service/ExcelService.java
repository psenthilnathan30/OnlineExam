package com.exam.service;

import java.util.List;

import com.exam.dto.ExcelFileBean;
import com.exam.dto.FileBean;

public interface ExcelService {

    public void importFile(FileBean fileBean);
    public List<ExcelFileBean> getQuestions(String examType);
}