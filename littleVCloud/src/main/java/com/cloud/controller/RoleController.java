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

import com.cloud.model.Role;
import com.cloud.model.User;
import com.cloud.service.RoleServiceI;

@Controller
@RequestMapping("/roleController")
public class RoleController {
	private RoleServiceI roleService;	

	

	public RoleServiceI getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(RoleServiceI roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value="/createRole",method=RequestMethod.POST)
	public @ResponseBody Role createRole(@RequestBody Role role) {
		
		if(roleService.createRole(role)>0)
			return role;
		else
			return null;
	}
	
	@RequestMapping(value="/modifyRole",method=RequestMethod.PUT)
	public @ResponseBody Role modifyRole(@RequestBody Role role) {

		if(roleService.modifyRole(role)>0)
			return role;
		else
			return null;
	}
	
	@RequestMapping(value="/deleteRole/{roleId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteRole( int roleId) {
		Map<String,String> map = new HashMap<String,String >();
		if(roleService.deleteRole(roleId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
		
	@RequestMapping(value="/deleteUserFromRole/{userId}-{roleId}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteUserFromRole(@PathVariable(value="userId") int userId, @PathVariable(value="roleId") int roleId) {
		Map<String,String> map = new HashMap<String,String >();
		if(roleService.deleteUserFromRole(userId, roleId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}
	@RequestMapping(value="/addUserToRole/{userId}-{roleId}",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> addUserToRole(@PathVariable(value="userId") int userId, @PathVariable(value="roleId") int roleId) {
		Map<String,String> map = new HashMap<String,String >();
		if(roleService.addUserToRole(userId, roleId)>0)
			{
				map.put("result", "success");
			}else{
				map.put("result", "failure");
			}
		return map;
	}	
	
	
	@RequestMapping("/getRoleById/{roleId}")
	public @ResponseBody Role getroleById(@PathVariable int roleId) {
		return roleService.getRoleById(roleId);		
	}
	
	@RequestMapping("/getRoleAndMembers/{roleId}")
	public @ResponseBody Role getroleAndMembers(@PathVariable int roleId) {
		return roleService.getRoleAndMembers(roleId);
	}
	
	@RequestMapping("/getAllRoles")
	public @ResponseBody List<Role> getAllroles() {
		return roleService.getAllRoles();		
	}
	
	@RequestMapping("/getRoleMembers/{roleId}")
	public @ResponseBody List<User> getRoleMembers(@PathVariable int roleId) {
		return roleService.getRoleMembers(roleId);		
	}

}
