package com.cloud.dao;

import java.util.List;

import com.cloud.model.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceid);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resourceid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    public List<Resource> getResourcesByName(String resourcename);
	public List<Resource> getResourcesByUploader(int uploaderid);
	public List<Resource> getResourcesByType(String resourcetype);
	public List<Resource> getSharedResource(int uploaderid);
	public List<Resource> getAllResources();
}