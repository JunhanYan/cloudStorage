package com.cloud.dao;

import java.util.List;

import com.cloud.model.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resourceid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    public List<Resource> getResourcesByName(String resourceName);
	public List<Resource> getResourcesByUploader(int uploaderId);
	public List<Resource> getResourcesByType(String resourceType);
	public List<Resource> getSharedResource(int uploaderId);
	public List<Resource> getAllResources();
}