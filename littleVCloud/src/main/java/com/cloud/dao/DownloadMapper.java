package com.cloud.dao;

import java.util.List;

import com.cloud.model.Download;
import com.cloud.model.Resource;
import com.cloud.model.User;

public interface DownloadMapper {
    int deleteByPrimaryKey(Integer downloadId);

    int insert(Download record);

    int insertSelective(Download record);

    Download selectByPrimaryKey(Integer downloadId);

    int updateByPrimaryKeySelective(Download record);

    int updateByPrimaryKey(Download record);
    
	public List<User> getResourceDownloadUsers(int resourceId);
	public List<Resource> getUserDownloadResources(int userId); 
	
}