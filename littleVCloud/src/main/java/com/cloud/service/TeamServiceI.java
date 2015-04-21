package com.cloud.service;

import java.util.List;

import com.cloud.model.Team;
import com.cloud.model.User;

public interface TeamServiceI {
	public Team getTeamById(int teamId);
	public int createTeam(Team team);
	public int deleteTeam(int teamId);
	public int modifyTeam(Team team);
	public List<Team> getTeamsByName(String teamname);
	
	public List<User> getTeamMembers(int teamId);
	public Team getTeamAndMembers(int teamId);
	
	public int addUserToTeam(int userId,int teamId);
	public int deleteUserFromTeam(int userId, int teamId);
	
	public List<Team> getAllTeams();

}
