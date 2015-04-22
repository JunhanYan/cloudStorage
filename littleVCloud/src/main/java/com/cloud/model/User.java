package com.cloud.model;

import java.util.List;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String userAccount;
    
    private List<Role> roles;
    
    private List<Team> teams;

    public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userid) {
        this.userId = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }
}