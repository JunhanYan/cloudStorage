package com.cloud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.service.UserServiceI;
import com.cloud.model.User;

@Controller

public class LoginController {
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
 
//	@RequestMapping(value="/login")
//	public String login(String userAccount,String password) {
//		
//		User user = userService.login(userAccount, password);
//		if(user!=null){
//			return "success";
//		}
//		
//		return "login";
//	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(String userAccount,String password) {
		ModelAndView mav = new ModelAndView("login");
		String tip = verify(userAccount, password);
		if(!("OK".equals(tip))){
			mav.addObject("tip", tip);
		}else{
			User user = userService.login(userAccount, password);
			if(user!=null){
				mav.setViewName("success");
			}
		}
		return mav;
	}
	public String verify(String userAccount,String password){
		String tip;
		if("".equals(userAccount.trim())||userAccount == null)
		{
			tip = "用户名为空";
		}else if("".equals(password.trim())||password == null){
			tip ="密码为空";
		}else if (userService.verifyAccountAvaliable(userAccount.trim())){
			tip = "用户名不存在";
		}else{
			tip = "OK";
		}
		return tip;
	}
}
