package com.cloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.service.UserServiceI;

import com.cloud.model.User;

@Controller
@RequestMapping("/userController")
public class UserController {
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
}
