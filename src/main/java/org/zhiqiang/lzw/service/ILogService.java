package org.zhiqiang.lzw.service;

import org.zhiqiang.lzw.entity.Log;

/**
 * 日志业务接口
 * @author LZW
 *
 */
public interface ILogService {
	
	/**
	 * 记录日志
	 * @param log
	 */
	public void recordLog(Log log) throws Exception;
	
	/**
	 * 记录日志到指定日志表
	 * @param tableName
	 * @param log
	 */
	public void recordLogToSpecifiedLogTable(String tableName,Log log);
	
	/**
	 * 通过表名创建日志表
	 * @param tableName
	 * @throws Exception
	 */
	public void createLogTable(String tableName) throws Exception;
}
