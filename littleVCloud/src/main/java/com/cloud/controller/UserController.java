package com.cloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.service.UserServiceI;
import com.cloud.test.TestUserProgram;
import com.cloud.model.User;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/userController")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	private UserServiceI userService;

	
	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping("/showUser/{userid}")
	public String showUser(@PathVariable int userid, HttpServletRequest request) {
		User u = userService.getUserById(userid);
		request.setAttribute("user", u);
		return "showUser";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User user) {
		
		System.out.println("++++++++++++++++"+user.getUserName()+user.getPassword()+user.getUserAccount());
		return "register";
//		if(userService.addUser(user)>0)
//			return "success";
//		else
//			return "failure";
	}
}
