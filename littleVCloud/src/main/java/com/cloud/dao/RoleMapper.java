package com.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Role;

import com.cloud.model.User;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    public List<User> getRoleMembers(int roleid);
    public Role getRoleAndMembers(int roleid);
    
    public int addUserToRole(@Param("userid") int userid,@Param("roleid") int roleid);
	public int deleteUserFromRole(@Param("userid") int userid,@Param("roleid") int roleid);
	
    public List<Role> getAllRoles();
}