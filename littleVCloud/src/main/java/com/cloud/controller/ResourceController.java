package com.cloud.controller;

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

import com.cloud.model.Resource;
import com.cloud.service.ResourceServiceI;


@Controller
@RequestMapping("/resourceController")
public class ResourceController {
	private ResourceServiceI resourceService;

	

	public ResourceServiceI getResourceService() {
		return resourceService;
	}
	@Autowired
	public void setResourceService(ResourceServiceI resourceService) {
		this.resourceService = resourceService;
	}

	@RequestMapping(value="/addResource",method=RequestMethod.POST)
	public @ResponseBody Resource addResource(@RequestBody Resource resource) {
		
		if(resourceService.addResource(resource)>0)
			return resource;
		else
			return null;
	}
	
	
	@RequestMapping(value="/modifyResource",method=RequestMethod.PUT)
	public @ResponseBody Resource modifyResource(@RequestBody Resource resource) {

		if(resourceService.modifyResource(resource)>0)
			return resource;
		else
			return null;
	}
	
	@RequestMapping(value="/deleteResource/{resourceId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteResource(@PathVariable int resourceId) {
		Map<String,String> map = new HashMap<String,String >();
		if(resourceService.deleteResource(resourceId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
	
	@RequestMapping("/getResourceById/{resourceId}")
	public @ResponseBody Resource getResourceById(@PathVariable int resourceId) {
		Resource resource = resourceService.getResourceById(resourceId);
		return resource;
	}
	
	
	@RequestMapping("/getAllResources")
	public @ResponseBody List<Resource> getAllresources() {
		return resourceService.getAllResources();		
	}
	
	@RequestMapping("/getResourcesByUploader/{uploaderId}")
	public @ResponseBody List<Resource> getResourcesByUploader(@PathVariable int uploaderId) {
		return resourceService.getResourcesByUploader(uploaderId);		
	}
	
	
	@RequestMapping("/getResourcesByName/{resourceName}")
	public @ResponseBody List<Resource> getResourcesByName(@PathVariable String resourceName) {
		return resourceService.getResourcesByName(resourceName);		
	}
	
	@RequestMapping("/getResourcesByType/{resourceType}-{uploaderId}")
	public @ResponseBody List<Resource> getResourcesByType(@PathVariable String resourceType,@PathVariable int uploaderId) {
		return resourceService.getResourcesByType(resourceType,uploaderId);		
	}
	
	@RequestMapping("/getResourcesByType/{resourceName}-{uploaderId}")
	public @ResponseBody List<Resource> getMyResourcesByName(@PathVariable String resourceName,@PathVariable int uploaderId) {
		return resourceService.getMyResourcesByName(resourceName, uploaderId);		
	}
	
	@RequestMapping("/getSharedResource/{uploaderId}")
	public @ResponseBody List<Resource> getSharedResource(@PathVariable int uploaderId) {
		return resourceService.getSharedResource(uploaderId);		
	}
	
	@RequestMapping("/getTrashResource/{uploaderId}")
	public @ResponseBody List<Resource> getTrashResource(@PathVariable int uploaderId) {
		return resourceService.getTrashResource(uploaderId);		
	}
	
	@RequestMapping("/getResourcesByFolder/{folderId}")
	public @ResponseBody List<Resource> getResourcesByFolder(@PathVariable int folderId) {
		return resourceService.getResourcesByFolder(folderId);		
	}
	
}
