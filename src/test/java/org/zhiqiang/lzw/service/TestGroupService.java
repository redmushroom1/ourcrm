package org.zhiqiang.lzw.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.custom.PageBean;

public class TestGroupService {
	private Logger logger = Logger.getLogger(TestGroupService.class);
	ApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
	}

	
	
	@Test
	public void testTotalRecords() {
		IGroupService groupService =  (IGroupService) context.getBean("groupService");
		int count = groupService.selectTotalRecords("%部%");
		System.out.println("记录总数为："+count);
	}
	
	/**
	 * 分页测试
	 */
	@Test
	public void testPage(){
		IGroupService groupService =  (IGroupService) context.getBean("groupService");
		PageBean pageBean = new PageBean();
		List<Group> group = groupService.selectByPage("%部%", pageBean);
		for (Group group2 : group) {
			System.out.println(group2);
		}
	}
	
	/**
	 * 新增部门
	 */
	@Test
	public void testAddGroup(){
		IGroupService groupService =  (IGroupService) context.getBean("groupService");
		Group record = new Group();
		record.setGroupname("采购部");
		record.setRemark("专注采购30年");
		/*Group record = new Group();
		record.setGroupname("工程部");
		record.setRemark("专业修路修桥");*/
		try {
			groupService.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量删除部门
	 * @throws Exception 
	 */
	@Test
	public void testBatchDeleteGroup() throws Exception{
		IGroupService groupService =  (IGroupService) context.getBean("groupService");
		Integer[] ids = new Integer[2];
		ids[0]=4;
		ids[1]=5;
		groupService.deleteByBatch(ids);
		
	}
	
	
	

}
