package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.City;
import org.zhiqiang.lzw.mapping.CityMapper;
import org.zhiqiang.lzw.service.CityService;

@Service("cityService")
public class CityServiceImpl implements CityService{

	@Autowired
	private CityMapper cityMapper;
	
	public void setCityMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	public int deleteByPrimaryKey(Integer id) {
		return cityMapper.deleteByPrimaryKey(id);
	}

	public int insert(City record) {
		return cityMapper.insert(record);
	}

	public int insertSelective(City record) {
		// TODO Auto-generated method stub
		return cityMapper.insertSelective(record);
	}

	public City selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return cityMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(City record) {
		// TODO Auto-generated method stub
		return cityMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(City record) {
		// TODO Auto-generated method stub
		return cityMapper.updateByPrimaryKey(record);
	}
}
