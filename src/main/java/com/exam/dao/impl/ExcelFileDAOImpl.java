package com.exam.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.exam.dao.ExcelFileDAO;
import com.exam.dto.ExcelFileBean;
import com.exam.util.PropertiesCache;

public class ExcelFileDAOImpl implements ExcelFileDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public ExcelFileDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public int[] insertExcelData(final List<ExcelFileBean> excelFileBeans) {
		String query = PropertiesCache.getInstance().getProperty(
				"INSERT_EXCEL_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int[] noOfRow = jdbcTemplate.batchUpdate(query,
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						ExcelFileBean excelFileBean = excelFileBeans.get(i);
						ps.setString(1, excelFileBean.getQuestion());
						ps.setString(2, excelFileBean.getOption_1());
						ps.setString(3, excelFileBean.getOption_2());
						ps.setString(4, excelFileBean.getOption_3());
						ps.setString(5, excelFileBean.getOption_4());
						ps.setString(6, excelFileBean.getAnswer());
						ps.setString(7, excelFileBean.getDescriptions());
						ps.setInt(8, 1);
					}

					public int getBatchSize() {
						return excelFileBeans.size();
					}
				});

		return noOfRow;

	}

	public List<ExcelFileBean> getQuestionsDetails(String examType) {
		String query = PropertiesCache.getInstance().getProperty(
				"GET_QUESTIONS_DETAILS");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ExcelFileBean> excelList=jdbcTemplate.query(query, new Object[]{examType},
				new RowMapper<ExcelFileBean>(){
					public ExcelFileBean mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						ExcelFileBean excelFile=new ExcelFileBean();
						excelFile.setQuestion(String.valueOf(rs.getString("question")));
						excelFile.setOption_1(String.valueOf(rs.getString("option_1")));
						excelFile.setOption_2(String.valueOf(rs.getString("option_2")));
						excelFile.setOption_3(String.valueOf(rs.getString("option_3")));
						excelFile.setOption_4(String.valueOf(rs.getString("option_4")));
						excelFile.setRowNum(rowNum);
						return excelFile;
					}
			
		});
		return excelList;
	}
	
	
	
	

	public List<ExcelFileBean> submitedDetails(String ans) {
	
		String query = PropertiesCache.getInstance().getProperty(
				"SUB_QUESTIONS_DETAILS");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ExcelFileBean> ansList=jdbcTemplate.query(query, new Object[]{ans},
				new RowMapper<ExcelFileBean>(){
					public ExcelFileBean mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						ExcelFileBean excelFile=new ExcelFileBean();
						excelFile.setAnswer(String.valueOf(rs.getString("ans")));
						excelFile.setRowNum(rowNum);
						return excelFile;
					}
			
		});
		return ansList;
	
	}
	

}
