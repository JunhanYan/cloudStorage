package com.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Follow;
import com.cloud.model.User;

public interface FollowMapper {
    int deleteByPrimaryKey(Integer followid);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Integer followid);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);
    
    public List<User> getTarget(int whoid);//被关注的人，查看当前用户所有关注的人，当前返回值仍然带有password
	public List<User> getWho(int targetid); //关注别人的人，查看所有关注当前用户的人，当前返回值仍然带有password
	public int deleteFollow(@Param("targetid") int targetid,@Param("whoid") int whoid);
    
}