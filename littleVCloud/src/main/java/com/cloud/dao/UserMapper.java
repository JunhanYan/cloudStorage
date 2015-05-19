package com.cloud.dao;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Role;
import com.cloud.model.Team;
import com.cloud.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(@Param("userAccount")String userAccount, @Param("password")String password);
   
    User verifyAccountAvaliable(String userAccount);
    
    List<Team> getUserTeams(int userId);
    List<Role> getUserRoles(int userId);
    
    User getUserAndTeams(int userId);
    User getUserAndRoles(int userId);
    List<User> getAllUsers();
}