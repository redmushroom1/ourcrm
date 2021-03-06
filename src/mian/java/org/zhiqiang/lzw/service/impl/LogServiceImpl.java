package org.zhiqiang.lzw.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Log;
import org.zhiqiang.lzw.mapping.LogMapper;
import org.zhiqiang.lzw.service.ILogService;
import org.zhiqiang.lzw.util.LogUtil;

/**
 * 日志业务实现
 * @author LZW
 *
 */
@Service("logService")
public class LogServiceImpl implements ILogService{
	
	@Autowired
	@Qualifier("logMapper")
	private LogMapper logMapper;
	
	/**
	 * 记录日志
	 */
	@Override
	public void recordLog(Log log) throws Exception {
		logMapper.insert(log);
	}
	
	/**
     * 插入日志到当前月对应的表中
     * @param map
     */
	@Override
	public void insertToMonthTable(Log log) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName",LogUtil.generateLogTableName(0));
		map.put("log", log);
		logMapper.insertToMonthTable(map);
	}
	
	
	/**
	 * 生成日志表
	 */
	@Override
	public void createLogTable(String tableName) throws Exception {
		String sql = "create table if not exists "+tableName+" like sys_log";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ourcrm", "root", "123");
		Statement stmt = connection.createStatement();
		boolean execute = stmt.execute(sql);
		try {
			stmt.close();
		} catch (Exception e) {
			throw e;
		}finally{
			connection.close();
		}
	}
	
	
	
	
	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}

	



	
	
}
