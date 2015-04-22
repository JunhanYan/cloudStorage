package com.cloud.model;

import java.util.List;

public class Team {
    private Integer teamId;

    private String teamName;
    
    private List<User> users;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamid) {
        this.teamId = teamid;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamname) {
        this.teamName = teamname == null ? null : teamname.trim();
    }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
    
}