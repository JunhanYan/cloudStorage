package com.cloud.service;

import java.util.List;

import com.cloud.model.User;
import com.cloud.model.Follow;

public interface FollowServiceI {

	public Follow getFollowById(int followId);
	public List<User> getTarget(int whoId);//被关注的人，查看当前用户所有关注的人
	public List<User> getWho(int targetId); //关注别人的人，查看所有关注当前用户的人
	public int addFollow(Follow record);
	public int deleteFollow(int targetId,int whoId);
}
