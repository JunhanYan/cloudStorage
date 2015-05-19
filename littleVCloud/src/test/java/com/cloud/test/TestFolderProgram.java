package com.cloud.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.model.Team;
import com.cloud.model.Folder;
import com.cloud.service.FolderServiceI;
import com.cloud.service.UserServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cloud.model.Role;

import java.util.List;



//import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class TestFolderProgram {

	private static final Logger logger = Logger.getLogger(TestFolderProgram.class);

	private FolderServiceI folderService;


	
	public FolderServiceI getFolderService() {
		return folderService;
	}
	@Autowired
	public void setFolderService(FolderServiceI folderService) {
		this.folderService = folderService;
	}
	
	
	
	
//	@Test
//	public void testDeleteByKey() {
//		
//			logger.info(userService.deleteUser(4));
//	}
	
	@Test
	public void testInsertUser() {
		Folder f =new Folder();
		f.setfolderName("home");
		f.setparentId(0);
		f.setuserId(1);
			logger.info(folderService.newFolder(f));
	}
	
	@Test
	public void testInsertUser2() {
		Folder f =new Folder();
		f.setfolderName("jh1");
		f.setparentId(1);
		f.setuserId(1);
			logger.info(folderService.newFolder(f));
	}
	
//	@Test
//	public void testModifyUser() {
//		User u = userService.getUserById(4);
//		u.setPassword("11");
//			logger.info(userService.modifyUser(u));
//	}	
}
