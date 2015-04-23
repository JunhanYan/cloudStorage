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

import com.cloud.model.Download;
import com.cloud.model.Resource;
import com.cloud.model.User;
import com.cloud.service.DownloadServiceI;


@Controller
@RequestMapping("/downloadController")
public class DownloadController {

	private DownloadServiceI downloadService;
	

	public DownloadServiceI getDownloadService() {
		return downloadService;
	}

	@Autowired
	public void setDownloadService(DownloadServiceI downloadService) {
		this.downloadService = downloadService;
	}


	@RequestMapping(value="/addDownloadLog",method=RequestMethod.POST)
	public @ResponseBody Download addDownloadLog(@RequestBody Download download) {
		
		if(downloadService.addDownloadLog(download)>0)
			return download;
		else
			return null;
	}
	
	
	
	@RequestMapping(value="/deleteDownload/{downloadId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteDownload( int downloadId) {
		Map<String,String> map = new HashMap<String,String >();
		if(downloadService.deleteDownloadLog(downloadId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
	
	@RequestMapping("/getDownloadById/{downloadId}")
	public @ResponseBody Download getDownloadById(@PathVariable int downloadId) {
		Download download = downloadService.getDownloadById(downloadId);
		return download;
	}
	
	
	@RequestMapping("/getResourceDownloadUsers/{resourceId}")
	public @ResponseBody List<User> getResourceDownloadUsers(@PathVariable int resourceId) {
		return downloadService.getResourceDownloadUsers(resourceId);		
	}
	
	@RequestMapping("/getUserDownloadResources/{userId}")
	public @ResponseBody List<Resource> getUserDownloadResources(@PathVariable int userId) {
		return downloadService.getUserDownloadResources(userId);		
	}
}
