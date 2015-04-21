package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.FollowMapper;
import com.cloud.model.Follow;
import com.cloud.model.User;
import com.cloud.service.FollowServiceI;
@Service("followService")
public class FollowServiceImpl implements FollowServiceI {

	private FollowMapper followMapper;
	public FollowMapper getFollowMapper(){
		return this.followMapper;
	}
	@Autowired
	public void setFollowMapper(FollowMapper followMapper){
		this.followMapper = followMapper;
	}
	@Override
	public Follow getFollowById(int followId) {
		return followMapper.selectByPrimaryKey(followId);
	}
	@Override
	public int addFollow(Follow record) {
		return followMapper.insertSelective(record);
	}
	@Override
	public int deleteFollow(int targetId, int whoId) {
		
		return followMapper.deleteFollow(targetId, whoId);
	}
	@Override
	public List<User> getTarget(int whoId) {
		return followMapper.getTarget(whoId);
	}
	@Override
	public List<User> getWho(int targetId) {
		return followMapper.getWho(targetId);
	}
}
