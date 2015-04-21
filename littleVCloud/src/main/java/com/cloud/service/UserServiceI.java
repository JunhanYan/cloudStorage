package com.cloud.service;

import java.util.List;

import com.cloud.model.Role;
import com.cloud.model.Team;
import com.cloud.model.User;

public interface UserServiceI {

	public User getUserById(int userId);
	public List<User> getAllUsers();
	public int addUser(User user);
	public int deleteUser(int userId);
	public int modifyUser(User user);
	public User getUserAllInfo(int userId);//尽量少用，表关联太多
	public List<Team> getUserTeams(int userId);
	public List<Role> getUserRoles(int userId);
	public User getUserAndRoles(int userId);
	public User getUserAndTeams(int userId);
	public User login(String userAccount, String password);
	public boolean verifyAccountAvaliable(String userAccount);
}
