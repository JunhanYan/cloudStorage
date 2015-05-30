package com.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Team;
import com.cloud.model.User;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer teamId);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer teamId);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
    
    public List<Team> getTeamsByName(String teamname);
	
	public List<User> getTeamMembers(int teamId); //此处返回的是带password的，如有需要进行更改
	public Team getTeamAndMembers(int teamId);//此处返回的也是带password的，如有需要进行更改
	
	public Team getTeamByTimeAndOwner(@Param("createTime") String createTime,@Param("ownerId") int ownerId);
	
	public int addUserToTeam(@Param("userId") int userId,@Param("teamId") int teamId);
	public int deleteUserFromTeam(@Param("userId") int userId,@Param("teamId") int teamId);
	public int deleteUsersFromTeam(int teamId);
    public List<Team> getAllTeams();
}