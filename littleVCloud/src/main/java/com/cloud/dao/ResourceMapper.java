package com.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.model.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resourceid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    public List<Resource> getResourcesByName(String resourceName);
    public List<Resource> getMyResourcesByName(@Param("resourceName") String resourceType,@Param("uploaderId") int uploaderId);
	public List<Resource> getResourcesByUploader(int uploaderId);
	public List<Resource> getResourcesByType(@Param("resourceType") String resourceType,@Param("uploaderId") int uploaderId);
	public List<Resource> getSharedResource(int uploaderId);
	public List<Resource> getResourcesByFolder(int folderId);
	public List<Resource> getAllResources();
	public List<Resource> getTrashResource(int uploaderId);
	
}