/*package com.cloud.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.model.Team;
import com.cloud.model.User;
import com.cloud.service.UserServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cloud.model.Role;

import java.util.List;



//import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class TestUserProgram {

	private static final Logger logger = Logger.getLogger(TestUserProgram.class);

	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	
	@Test
	public void test1() {
		User u = userService.getUserById(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(u));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testLogin() {
		User u = userService.login("yanjunhan", "1");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(u));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testVerifyAccountAvaliable() {
//		boolean existUser = userService.verifyAccountAvaliable("yanjunhan");
//		
//			logger.info(existUser+"=======================");
//	}
	
	@Test
	public void testUserAndTeams() {
		User u = userService.getUserAndTeams(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(u));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testUserTeams() {
		//User u = userService.getUserAndTeams(1);
		List<Team> teams= userService.getUserTeams(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(teams));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUserAndRoles() {
		User u = userService.getUserAndRoles(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(u));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testUserRoles() {
		//User u = userService.getUserAndTeams(1);
		List<Role> teams= userService.getUserRoles(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(teams));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllUsers() {
		//User u = userService.getUserAndTeams(1);
		List<User> users= userService.getAllUsers();
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
		
			logger.info(userService.deleteUser(4));
	}
	
	@Test
	public void testInsertUser() {
		User u =new User();
		u.setUserName("test2");
		u.setPassword("1");
		u.setUserAccount("test2");
			logger.info(userService.addUser(u));
	}
	
	@Test
	public void testModifyUser() {
		User u = userService.getUserById(4);
		u.setPassword("11");
			logger.info(userService.modifyUser(u));
	}	
}
*/