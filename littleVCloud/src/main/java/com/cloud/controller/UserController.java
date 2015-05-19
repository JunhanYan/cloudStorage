package com.cloud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.cloud.service.FolderServiceI;
import com.cloud.service.UserServiceI;
import com.cloud.model.Folder;
import com.cloud.model.Role;
import com.cloud.model.Team;
import com.cloud.model.User;



@Controller
@RequestMapping("/userController")
public class UserController {
	
	private UserServiceI userService;
	private FolderServiceI folderService;
	
	public FolderServiceI getFolderService() {
		return folderService;
	}
	@Autowired
	public void setFolderService(FolderServiceI folderService) {
		this.folderService = folderService;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody User register(@RequestBody User user) {
		
		if(userService.addUser(user)>0)
		{
			user=userService.verifyAccountAvaliable(user.getUserAccount());
			Folder folder = new Folder();
			folder.setfolderName("home");
			folder.setparentId(0);
			folder.setuserId(user.getUserId());
			folder.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			folderService.newFolder(folder);
			return user;
		}else
			return null;
	}
	
	@RequestMapping("/verifyUserAccount/{userAccount}")
	public @ResponseBody Map<String, String> verifyUserAccount(@PathVariable String userAccount) {
		Map<String,String> map = new HashMap<String,String >();
		if(userService.verifyAccountAvaliable(userAccount)!=null)
			{
				map.put("result", "avaliable");
			}else{
				map.put("result", "unavaliable");
			}
		return map;
	}
	
	@RequestMapping("/getUserById/{userId}")
	public @ResponseBody User getUserById(@PathVariable int userId) {
		User user = userService.getUserById(userId);
		return user;
	}
	
	@RequestMapping("/getUserAndRoles/{userId}")
	public @ResponseBody User getUserAndRoles(@PathVariable int userId) {
		User user = userService.getUserAndRoles(userId);
		return user;
	}
	@RequestMapping("/getUserAndTeams/{userId}")
	public @ResponseBody User getUserAndTeams(@PathVariable int userId) {
		User user = userService.getUserAndTeams(userId);
		return user;
	}
	
	@RequestMapping("/getAllUsers")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();		
	}
	
	@RequestMapping("/getUserTeams/{userId}")
	public @ResponseBody List<Team> getUserTeams(@PathVariable int userId) {
		return userService.getUserTeams(userId);		
	}
	
	@RequestMapping("/getUserRoles/{userId}")
	public @ResponseBody List<Role> getUserRoles(@PathVariable int userId) {
		return userService.getUserRoles(userId);		
	}
	
	@RequestMapping(value="/modifyUser",method=RequestMethod.PUT)
	public @ResponseBody User modifyUser(@RequestBody User user) {

		if(userService.modifyUser(user)>0)
			return user;
		else
			return null;
	}
	
	@RequestMapping(value="/deleteUser/{userId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteUser( int userId) {
		Map<String,String> map = new HashMap<String,String >();
		if(userService.deleteUser(userId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
}
