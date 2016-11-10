package org.zhiqiang.lzw.service;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.City;
import org.zhiqiang.lzw.entity.custom.PageBean;

/**
 * 城市业务接口类
 * @author Administrator
 *
 */
public interface ICityService {
	
	/**
	 * 获取所有记录数
	 * @return
	 */
	int getConuts(Integer pid) throws Exception;
	
	/**
	 * 获取所有城市记录
	 * @return
	 */
	List<City> getAllCity() throws Exception;
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public Map<String, Object> getByPage(Integer pid, PageBean pageBean) throws Exception;
	
	/**
	 * 根据ID获取详情
	 * @param id
	 * @return
	 */
	City getCityById(Integer id) throws Exception;
	
	/**
	 * 根据省份查询对应城市
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	List<City> getCitysByPid(Integer pid) throws Exception;
	
	/**
	 * 新增城市
	 * @param city
	 * @return
	 */
	int insertCity(City city) throws Exception;

	/**
	 * 删除单个城市
	 * @param id
	 * @return
	 */
	int deleteOneById(Integer id) throws Exception;
	
	/**
	 * 修改城市信息
	 * @param city
	 * @return
	 */
	int updateCity(City city) throws Exception;
	
}
