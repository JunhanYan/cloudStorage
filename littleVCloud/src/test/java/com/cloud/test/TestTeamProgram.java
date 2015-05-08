/*package com.cloud.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.model.Team;
import com.cloud.model.User;
import com.cloud.service.TeamServiceI;
import com.cloud.service.UserServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cloud.model.Role;

import java.util.List;



//import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class TestTeamProgram {

	private static final Logger logger = Logger.getLogger(TestUserProgram.class);

	private TeamServiceI teamService;
	

	
	public TeamServiceI getTeamService() {
		return teamService;
	}
	@Autowired
	public void setTeamService(TeamServiceI teamService) {
		this.teamService = teamService;
	}
	@Test
	public void test1() {
		Team team = teamService.getTeamById(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(team));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTeamAndMembers() {
		Team team = teamService.getTeamAndMembers(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(team));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllTeams() {
		List<Team> teams= teamService.getAllTeams();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(teams));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTeamsByName() {
		List<Team> teams= teamService.getTeamsByName("test");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(teams));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTeamMembers() {
		List<User> users= teamService.getTeamMembers(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(users));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteByKey() {
		
			logger.info(teamService.deleteTeam(3));
	}
	
	@Test
	public void testInsertTeam() {
		Team team = new Team();
		team.setTeamName("test1");
			logger.info(teamService.createTeam(team));
	}
	
	@Test
	public void testModifyTeam() {
		Team team = teamService.getTeamById(3);
		team.setTeamName("test2");
			logger.info(teamService.modifyTeam(team));
	}	
	@Test
	public void testAddUserToTeam() {		
			logger.info(teamService.addUserToTeam(1, 3));
	}	
	@Test
	public void testDeleteUserFromTeam() {		
			logger.info(teamService.deleteUserFromTeam(1, 3));
	}	
}
	*/