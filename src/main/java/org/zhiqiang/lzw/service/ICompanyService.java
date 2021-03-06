package org.zhiqiang.lzw.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Company;
import org.zhiqiang.lzw.entity.custom.PageBean;

public interface ICompanyService {
	
    List<Company> selectByPage(PageBean pageBean)throws Exception;
    
    int selectTotalRecords()throws Exception;

	List<Company> getAllCompany() throws Exception;
	
	Map<String, Object> fuzzySearchCompany(String data, PageBean pageBean) throws Exception;
	
	List<Company> getCompanyWhereTodayNeedTouch(String date) throws Exception;
	
	List<Company> getCompanyWhereForgetTouch(String date) throws Exception;
	
	Company getCompanyById(Integer id) throws Exception;
	
	int insertCompany(Company company) throws Exception;
	
	int deleteById(Integer id) throws Exception;
	
	int updateCompany(Company company) throws Exception;
	
	int updateNextTouchTime(Integer id, Date nexttouchdate) throws Exception;
	
}
