package com.cloud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.model.Team;
import com.cloud.model.User;
import com.cloud.service.TeamServiceI;
import com.cloud.service.UserServiceI;


@Controller
@RequestMapping("/teamController")
public class TeamController {
	private TeamServiceI teamService;	
	private UserServiceI userService;
	public UserServiceI getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	public TeamServiceI getTeamService() {
		return teamService;
	}
	@Autowired
	public void setTeamService(TeamServiceI teamService) {
		this.teamService = teamService;
	}

	@RequestMapping(value="/createTeam",method=RequestMethod.POST)
	public @ResponseBody Team createTeam(@RequestBody Team team) {
		String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		team.setCreateTime(createTime);
		if(teamService.createTeam(team)>0)
		{
			team = teamService.getTeamByTimeAndOwner(createTime, team.getOwnerId());
			return team;
		}else
			return null;
	}
	
	@RequestMapping(value="/modifyTeam",method=RequestMethod.PUT)
	public @ResponseBody Team modifyTeam(@RequestBody Team team) {

		if(teamService.modifyTeam(team)>0)
			return team;
		else
			return null;
	}
	
	@RequestMapping(value="/deleteTeam/{teamId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteTeam(@PathVariable int teamId) {
		Map<String,String> map = new HashMap<String,String >();
		if(teamService.deleteTeam(teamId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
	
	@RequestMapping(value="/deleteUserFromTeam/{userId}-{teamId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteUserFromTeam(@PathVariable(value="userId") int userId, @PathVariable(value="teamId") int teamId) {
		Map<String,String> map = new HashMap<String,String >();
		if(teamService.deleteUserFromTeam(userId, teamId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
	@RequestMapping(value="/addUserToTeam/{userId}-{teamId}",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> addUserToTeam(@PathVariable(value="userId") int userId, @PathVariable(value="teamId") int teamId) {
		Map<String,String> map = new HashMap<String,String >();
		if(teamService.addUserToTeam(userId, teamId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}	
	
	@RequestMapping(value="/addUserToTeamByAccount/{userAccount}-{teamId}",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> addUserToTeamByAccount(@PathVariable(value="userAccount") String userAccount, @PathVariable(value="teamId") int teamId) {
		Map<String,String> map = new HashMap<String,String >();
		if(teamService.addUserToTeam(userService.verifyAccountAvaliable(userAccount).getUserId(), teamId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}	
	
	@RequestMapping("/getTeamById/{teamId}")
	public @ResponseBody Team getTeamById(@PathVariable int teamId) {
		Team Team = teamService.getTeamById(teamId);
		return Team;
	}
	
	@RequestMapping("/getTeamAndMembers/{teamId}")
	public @ResponseBody Team getTeamAndMembers(@PathVariable int teamId) {
		Team Team = teamService.getTeamAndMembers(teamId);
		return Team;
	}
	
	@RequestMapping("/getAllTeams")
	public @ResponseBody List<Team> getAllTeams() {
		return teamService.getAllTeams();		
	}
	
	@RequestMapping("/getTeamMembers/{teamId}")
	public @ResponseBody List<User> getTeamMembers(@PathVariable int teamId) {
		return teamService.getTeamMembers(teamId);		
	}
	
	@RequestMapping("/getTeamsByName/{teamName}")
	public @ResponseBody List<Team> getTeamsByName(@PathVariable String teamName) {
		return teamService.getTeamsByName(teamName);		
	}
	
	
}
