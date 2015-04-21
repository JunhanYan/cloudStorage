package com.cloud.service;

import java.util.List;

import com.cloud.model.Role;
import com.cloud.model.User;

public interface RoleServiceI {
	public Role getRoleById(int roleId);
	
	public List<User> getRoleMembers(int roleId);
	public Role getRoleAndMembers(int roleId);
	
	public int addUserToRole(int userId,int roleId);
	public int deleteUserFromRole(int userId, int roleId);
	
	
	public List<Role> getAllRoles();

}
