package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.RoleMapper;
import com.cloud.model.Role;
import com.cloud.model.User;
import com.cloud.service.RoleServiceI;
@Service("roleService")
public class RoleServiceImpl implements RoleServiceI {
	
	private RoleMapper roleMapper;
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	
	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	@Override
	public int addUserToRole(int userId, int roleId) {
		
		return roleMapper.addUserToRole(userId, roleId);
	}
	@Override
	public int deleteUserFromRole(int userId, int roleId) {
		return roleMapper.deleteUserFromRole(userId, roleId);
	}
	@Override
	public Role getRoleById(int roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}
	@Override
	public List<User> getRoleMembers(int roleId) {
	
		return roleMapper.getRoleMembers(roleId);
	}
	@Override
	public List<Role> getAllRoles() {
		return roleMapper.getAllRoles();
	}
	@Override
	public Role getRoleAndMembers(int roleId){
		return roleMapper.getRoleAndMembers(roleId);
	}
}
