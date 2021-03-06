package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.custom.UserCustom;
import org.zhiqiang.lzw.mapping.UserMapper;
import org.zhiqiang.lzw.service.IUserService;
import org.zhiqiang.lzw.util.MD5keyBean;

/**
 * 用户业务实现
 * @author LZW
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	//用户登录
	@Override
	public UserCustom login(String name, String password) {
		//将密码进行MD5加密
		MD5keyBean md5 = new MD5keyBean();
		password = md5.getkeyBeanofStr(password);
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("password", password);
		return userMapper.selectByNameAndPassword(map);
	}
	
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	
}
