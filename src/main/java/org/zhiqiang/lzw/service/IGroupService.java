package org.zhiqiang.lzw.service;

import java.util.List;

import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.custom.GroupCustom;
import org.zhiqiang.lzw.entity.custom.PageBean;

/**
 * 部门业务接口
 * @author LZW
 *
 */
public interface IGroupService {
	/**
     * 带条件分页查询
     * @param groupName
     * @return
     */
    List<Group> selectByPage(String groupName,PageBean pageBean);
    
    /**
     * 带条件查询总记录数
     * @param groupName
     * @return
     */
    int selectTotalRecords(String groupName);
    
    
    /**
     * 批量删除部门
     * @param ids
     */
    void deleteByBatch(Integer[] ids) throws Exception;
    
    /**
     * 新增部门
     * @param record
     * @return
     * @throws Exception
     */
    void insert(Group record) throws Exception;
    
    /**
     * 根据部门编号查找指定部门（部门关联查询用户）
     * @param groupId
     * @return
     */
    GroupCustom selectGroupCustom(Integer groupId);
    
    /**
     * 查询所有部门
     * @return
     */
    public List<Group> selectAllGroup();
}
