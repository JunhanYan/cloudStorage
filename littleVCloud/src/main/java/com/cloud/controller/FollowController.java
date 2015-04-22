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

import com.cloud.model.Follow;
import com.cloud.model.Team;
import com.cloud.model.User;
import com.cloud.service.FollowServiceI;
@Controller
@RequestMapping("/followController")
public class FollowController {

	
	private FollowServiceI followService;

	public FollowServiceI getFollowService() {
		return followService;
	}
	@Autowired
	public void setFollowService(FollowServiceI followService) {
		this.followService = followService;
	}
	
	
	@RequestMapping(value="/addFollow",method=RequestMethod.POST)
	public @ResponseBody Follow createTeam(@RequestBody Follow follow) {
		
		if(followService.addFollow(follow)>0)
			return follow;
		else
			return null;
	}
	
	@RequestMapping(value="/deleteFollow/{targetId}-{whoId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteFollow(@PathVariable(value="targetId") int targetId, @PathVariable(value="whoId") int whoId) {
		Map<String,String> map = new HashMap<String,String >();
		if(followService.deleteFollow(targetId, whoId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
	
	@RequestMapping("/getFollowById/{followId}")
	public @ResponseBody Follow getFollowById(@PathVariable int followId) {
		return followService.getFollowById(followId);
	}
	
	@RequestMapping("/getWho/{targetId}")
	public @ResponseBody List<User> getWho(@PathVariable int targetId) {
		return followService.getWho(targetId);		
	}
	
	@RequestMapping("/getTarget/{whoId}")
	public @ResponseBody List<User> getTarget(@PathVariable int whoId) {
		return followService.getTarget(whoId);		
	}
}
