package org.zhiqiang.lzw.entity.custom;

import java.util.Arrays;
import java.util.List;

import org.zhiqiang.lzw.entity.Group;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.Role;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.UserWithBLOBs;

/**
 * 用户自定义类，包含角色集合以及权限集合
 * @author LZW
 *
 */
public class UserCustom extends UserWithBLOBs{
	
	//用户拥有的角色
	private List<RoleCustom> roleCustoms;
	
	//用户所在部门
	private Group group;
	
	//保存用户每个权限位的权限总和
	private Long[] privilegeSum;

	
	
	public List<RoleCustom> getRoles() {
		return roleCustoms;
	}

	public List<RoleCustom> getRoleCustoms() {
		return roleCustoms;
	}

	public void setRoleCustoms(List<RoleCustom> roleCustoms) {
		this.roleCustoms = roleCustoms;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Long[] getPrivilegeSum() {
		return privilegeSum;
	}

	public void setPrivilegeSum(Long[] privilegeSum) {
		this.privilegeSum = privilegeSum;
	}

	@Override
	public String toString() {
		return "UserCustom [roleCustoms=" + roleCustoms + ", group=" + group
				+ ", privilegeSum=" + Arrays.toString(privilegeSum) + "]";
	}
	
	
	
	
	
}
