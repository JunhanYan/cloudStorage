package com.cloud.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.model.Follow;

import com.cloud.model.User;
import com.cloud.service.FollowServiceI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;



//import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class TestFollowProgram {

	private static final Logger logger = Logger.getLogger(TestUserProgram.class);

	private FollowServiceI followService;
	
	public FollowServiceI getFollowService() {
		return followService;
	}
	@Autowired
	public void setFollowService(FollowServiceI followService) {
		this.followService = followService;
	}

	@Test
	public void test1() {
		Follow  follow = followService.getFollowById(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(follow));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Test
	public void testGetTarget() {
		List<User> users= followService.getTarget(2);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(users));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetWho() {
		List<User> users= followService.getWho(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(users));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testInsertTeam() {
		Follow follow =new Follow();
		follow.setTarget(1);
		follow.setWho(2);
			logger.info(followService.addFollow(follow));
	}
	
	
	
	@Test
	public void testDeleteUserFromTeam() {		
			logger.info(followService.deleteFollow(1, 2));
	}	
}
