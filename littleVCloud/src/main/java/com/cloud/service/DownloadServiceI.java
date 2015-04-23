package com.cloud.service;

import java.util.List;

import com.cloud.model.Download;
import com.cloud.model.Resource;
import com.cloud.model.User;

public interface DownloadServiceI {
	
	public Download getDownloadById(int downloadId);
	public List<User> getResourceDownloadUsers(int resourceId);
	public List<Resource> getUserDownloadResources(int userId); 
	public int addDownloadLog(Download download);
	public int deleteDownloadLog(int downloadId);

}
