package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.TeamMapper;
import com.cloud.model.Team;
import com.cloud.model.User;
import com.cloud.service.TeamServiceI;


@Service("teamService")
public class TeamServiceImpl implements TeamServiceI {

	private TeamMapper teamMapper;
	
	public TeamMapper getTeamMapper() {
		return teamMapper;
	}
	@Autowired
	public void setTeamMapper(TeamMapper teamMapper) {
		this.teamMapper = teamMapper;
	}
	@Override
	public int addUserToTeam(int userId, int teamId) {
		
		return teamMapper.addUserToTeam(userId, teamId);
	}
	@Override
	public int createTeam(Team team) {
		
		return teamMapper.insertSelective(team);
	}
	@Override
	public int deleteTeam(int teamId) {
		
		return teamMapper.deleteByPrimaryKey(teamId);
	}
	@Override
	public int deleteUserFromTeam(int userId, int teamId) {
		
		return teamMapper.deleteUserFromTeam(userId, teamId);
	}
	@Override
	public Team getTeamAndMembers(int teamId) {
		
		return teamMapper.getTeamAndMembers(teamId);
	}
	@Override
	public Team getTeamById(int teamId) {

		return teamMapper.selectByPrimaryKey(teamId);
	}
	@Override
	public List<User> getTeamMembers(int teamId) {
		
		return teamMapper.getTeamMembers(teamId);
	}
	@Override
	public List<Team> getTeamsByName(String teamname) {
		
		return teamMapper.getTeamsByName(teamname);
	}
	@Override
	public int modifyTeam(Team team) {
	
		return teamMapper.updateByPrimaryKeySelective(team);
	}
	@Override
	public List<Team> getAllTeams() {
		return teamMapper.getAllTeams();
	}
}
