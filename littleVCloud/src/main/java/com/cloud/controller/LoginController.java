package com.cloud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
 
	//返回json @ResponseBody，直接把json返回view
	//         @RequestBody 解析view发来的json 
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody User login(@RequestBody User reqUser) {
		User user = userService.login(reqUser.getUserAccount(), reqUser.getPassword());
		if(user!=null)
			return user;
		else
			return null;
		/*System.out.println("==========================="+user.getUserAccount()+user.getPassword()+user.getUserName());
		return null;*/
	}
	//先不实现，如有需要新建个token表
	@RequestMapping(value="/loginByToken")
	public @ResponseBody User loginByToken(String token) {
		return null;
	}
	
	
	//跳转页面
/*	@RequestMapping(value="/login",method=RequestMethod.POST)
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
	}*/
	@RequestMapping(value="/verify")
	public @ResponseBody String verify(String userAccount,String password){
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
