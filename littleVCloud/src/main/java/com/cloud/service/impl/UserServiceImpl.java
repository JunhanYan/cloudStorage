package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.service.UserServiceI;
import com.cloud.dao.UserMapper;
import com.cloud.model.Role;
import com.cloud.model.Team;
import com.cloud.model.User;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	
	public UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public int addUser(User user) {
		
		return userMapper.insertSelective(user);
	}
	@Override
	public int deleteUser(int userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}
	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}
	@Override
	public User getUserAllInfo(int userId) { //暂时不写关联太多，性能太差可能没有用
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getUserAndRoles(int userId) {
		return userMapper.getUserAndRoles(userId);
	}
	
	@Override
	public User getUserAndTeams(int userId) {
		User userTeams = userMapper.getUserAndTeams(userId);
		return userTeams;
	}
	@Override
	public List<Team> getUserTeams(int userId) {
		return userMapper.getUserTeams(userId);
	}
	@Override
	public List<Role> getUserRoles(int userId) {
		return userMapper.getUserRoles(userId);
	}
	@Override
	public int modifyUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public User login(String userAccount, String password) {
		
		return userMapper.login(userAccount, password);
	}
	@Override
	public User verifyAccountAvaliable(String userAccount) { 
		return userMapper.verifyAccountAvaliable(userAccount);
			
	}
}
