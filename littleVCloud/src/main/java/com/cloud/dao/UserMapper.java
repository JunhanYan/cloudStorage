package com.cloud.dao;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Role;
import com.cloud.model.Team;
import com.cloud.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(@Param("userAccount")String userAccount, @Param("password")String password);
   
    User verifyAccountAvaliable(String userAccount);
    
    List<Team> getUserTeams(int userid);
    List<Role> getUserRoles(int userid);
    
    User getUserAndTeams(int userid);
    User getUserAndRoles(int userid);
    
    List<User> getAllUsers();
}