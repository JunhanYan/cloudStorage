package com.cloud.service;

import java.util.List;

import com.cloud.model.Resource;

public interface ResourceServiceI {
	public Resource getResourceById(int resourceId);
	public List<Resource> getResourcesByName(String resourceName);
	public List<Resource> getResourcesByUploader(int uploaderId);
	public List<Resource> getResourcesByType(String resourceType,int uploaderId);
	public int addResource(Resource resource);
	public int deleteResource(int resourceId);
	public int modifyResource(Resource resource);
	public boolean isCompleted(int resourceId);
	public int getCurrentProcess(int resourceId); //用于断点续传
	public boolean isResourceExist(String resourceName); //用于实现秒传
	public String changeName(String resourceName);//MD5
	public List<Resource> getSharedResource(int uploaderId);
	public List<Resource> getTrashResource(int uploaderId);
	public List<Resource> getResourcesByFolder(int folderId);
	public List<Resource> getAllResources();
	//目录考虑由前台js解析path建立

}
