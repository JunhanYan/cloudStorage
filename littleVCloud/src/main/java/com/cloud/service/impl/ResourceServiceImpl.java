package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.ResourceMapper;
import com.cloud.model.Resource;
import com.cloud.service.ResourceServiceI;
@Service("resourceService")
public class ResourceServiceImpl implements ResourceServiceI {
	
	private ResourceMapper resourceMapper;
	
	public ResourceMapper getResourceMapper() {
		return resourceMapper;
	}
	@Autowired
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}
	@Override
	public int addResource(Resource resource) {
		return resourceMapper.insertSelective(resource);
	}
	@Override
	public int deleteResource(int resourceId) {
		return resourceMapper.deleteByPrimaryKey(resourceId);
	}
	@Override
	public Resource getResourceById(int resourceId) {
		return resourceMapper.selectByPrimaryKey(resourceId);
	}
	@Override
	public List<Resource> getResourcesByName(String resourceName) {
		return resourceMapper.getResourcesByName(resourceName);
	}
	@Override
	public List<Resource> getResourcesByType(String resourceType,int uploaderId) {
		return resourceMapper.getResourcesByType(resourceType,uploaderId);
	}
	@Override
	public List<Resource> getResourcesByUploader(int uploaderId) {
		return resourceMapper.getResourcesByUploader(uploaderId);
	}
	@Override
	public int modifyResource(Resource resource) {
		return resourceMapper.updateByPrimaryKeySelective(resource);
	}
	@Override
	public String changeName(String resourceName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getCurrentProcess(int resourceId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Resource> getSharedResource(int uploaderId) {
		
		return resourceMapper.getSharedResource(uploaderId);
	}
	@Override
	public List<Resource> getTrashResource(int uploaderId) {
		return resourceMapper.getTrashResource(uploaderId);
	}
	@Override
	public boolean isCompleted(int resourceId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isResourceExist(String resourceName) {
		if(resourceMapper.getResourcesByName(resourceName)!=null){
			return true;
		}
		return false;
	}
	
	@Override
	public List<Resource> getAllResources() {
		return resourceMapper.getAllResources();
	}
	@Override
	public List<Resource> getResourcesByFolder(int folderId) {
		return resourceMapper.getResourcesByFolder(folderId);
	}
	@Override
	public List<Resource> getMyResourcesByName(String resourceName,
			int uploaderId) {
		return resourceMapper.getMyResourcesByName(resourceName, uploaderId);
	}
}
