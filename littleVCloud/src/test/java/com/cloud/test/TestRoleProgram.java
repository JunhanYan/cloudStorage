/*package com.cloud.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.model.Team;
import com.cloud.model.User;
import com.cloud.service.RoleServiceI;
import com.cloud.service.TeamServiceI;
import com.cloud.service.UserServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cloud.model.Role;

import java.util.List;



//import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class TestRoleProgram {

	private static final Logger logger = Logger.getLogger(TestRoleProgram.class);

	private RoleServiceI roleService;
	

	public RoleServiceI getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(RoleServiceI roleService) {
		this.roleService = roleService;
	}

	@Test
	public void test1() {
		Role role = roleService.getRoleById(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(role));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTeamAndMembers() {
		Role role = roleService.getRoleAndMembers(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(role));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllRoles() {
		List<Role> roles= roleService.getAllRoles();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(roles));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void testGetRoleMembers() {
		List<User> users= roleService.getRoleMembers(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(users));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	@Test
	public void testAddUserToRole() {		
			logger.info(roleService.addUserToRole(2, 1));
	}	
	@Test
	public void testDeleteUserFromRole() {		
			logger.info(roleService.deleteUserFromRole(2, 1));
	}
}*/