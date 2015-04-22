package com.cloud.model;

import java.util.List;

public class Role {
    private Integer roleId;

    private String roleName;

    private List<User> users;
    
    public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleid) {
        this.roleId = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String rolename) {
        this.roleName = rolename == null ? null : rolename.trim();
    }
}