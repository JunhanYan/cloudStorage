/*package com.cloud.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.model.Resource;
import com.cloud.model.Team;
import com.cloud.model.User;
import com.cloud.service.ResourceServiceI;
import com.cloud.service.TeamServiceI;
import com.cloud.service.UserServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cloud.model.Role;

import java.util.List;



//import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class TestResourceProgram {

	private static final Logger logger = Logger.getLogger(TestResourceProgram.class);

	private ResourceServiceI resourceService;
	


	public ResourceServiceI getResourceService() {
		return resourceService;
	}
	@Autowired
	public void setResourceService(ResourceServiceI resourceService) {
		this.resourceService = resourceService;
	}

	@Test
	public void testGetResourceById() {
		Resource resource = resourceService.getResourceById(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(resource));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetResourcesByName() {
		List<Resource> resources = resourceService.getResourcesByName("file");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(resources));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetMyResourcesByName() {
		List<Resource> resources = resourceService.getMyResourcesByName("file",1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(resources));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetResourcesByType() {
		List<Resource> resources = resourceService.getResourcesByType("doc",1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(resources));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetResourcesByUploader() {
		List<Resource> resources = resourceService.getResourcesByUploader(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(resources));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetResourcesByFolder() {
		List<Resource> resources = resourceService.getResourcesByFolder(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(resources));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetSharedResource() {
		List<Resource> resources = resourceService.getSharedResource(1);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(resources));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testDeleteByKey() {
		
			logger.info(resourceService.deleteResource(3));
	}
	
	@Test
	public void testInsert() {
			Resource resource = new Resource();
			resource.setResourceName("myfile");
			resource.setDescription("aaaaaa");
			resource.setDownloadTimes(2);
			resource.setPath("/home/mydir/");
			resource.setSize(20);
			resource.setType("doc");
			resource.setUploaderId(1);
			resource.setStatus(1);
			resource.setUploadTime("2015-4-20");
			logger.info(resourceService.addResource(resource));
	}
	
	@Test
	public void testModifyTeam() {
		Resource resource = new Resource();
		resource.setResourceId(2);
		resource.setStatus(2);
			logger.info(resourceService.modifyResource(resource));
	}
}
*/