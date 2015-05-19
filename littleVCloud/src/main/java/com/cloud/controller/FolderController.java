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

import com.cloud.model.Folder;
import com.cloud.model.Resource;
import com.cloud.service.FolderServiceI;
import com.cloud.service.ResourceServiceI;


@Controller
@RequestMapping("/folderController")
public class FolderController {
	
	public FolderServiceI folderService;
	
	public FolderServiceI getFolderService() {
		return folderService;
	}

	@Autowired
	public void setFolderService(FolderServiceI folderService) {
		this.folderService = folderService;
	}


	@RequestMapping(value="/newFolder",method=RequestMethod.POST)
	public @ResponseBody Folder newFolder(@RequestBody Folder folder) {
		
		if(folderService.newFolder(folder)>0)
			return folder;
		else
			return null;
	}
	
	
	@RequestMapping(value="/modifyFolder",method=RequestMethod.PUT)
	public @ResponseBody Folder modifyFolder(@RequestBody Folder folder) {

		if(folderService.modifyFolder(folder)>0)
			return folder;
		else
			return null;
	}
	
	@RequestMapping(value="/deleteFolderById/{folderId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteFolderById(@PathVariable int folderId) {
		Map<String,String> map = new HashMap<String,String >();
		if(folderService.deleteFolderById(folderId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
	
	@RequestMapping("/getFolderById/{folderId}")
	public @ResponseBody Folder getFolderById(@PathVariable int folderId) {
		return folderService.getFolderById(folderId);
	}
				
	@RequestMapping("/getFolderByParentAndUser/{parentId}-{userId}")
	public @ResponseBody List<Folder> getFolderByParentAndUser(@PathVariable int parentId,@PathVariable int userId) {
		return folderService.getFolderByParentAndUser(parentId, userId);		
	}
	
	
}
