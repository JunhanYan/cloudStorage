package com.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Role;

import com.cloud.model.User;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    public List<User> getRoleMembers(int roleid);
    public Role getRoleAndMembers(int roleId);
    
    public int addUserToRole(@Param("userId") int userid,@Param("roleId") int roleid);
	public int deleteUserFromRole(@Param("userId") int userid,@Param("roleId") int roleid);
	
    public List<Role> getAllRoles();
}