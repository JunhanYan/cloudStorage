package com.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Team;
import com.cloud.model.User;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer teamid);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer teamid);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
    
    public List<Team> getTeamsByName(String teamname);
	
	public List<User> getTeamMembers(int teamid); //此处返回的是带password的，如有需要进行更改
	public Team getTeamAndMembers(int teamid);//此处返回的也是带password的，如有需要进行更改
	
	public int addUserToTeam(@Param("userid") int userid,@Param("teamid") int teamid);
	public int deleteUserFromTeam(@Param("userid") int userid,@Param("teamid") int teamid);
	
    public List<Team> getAllTeams();
}