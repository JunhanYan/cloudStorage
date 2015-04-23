package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.DownloadMapper;
import com.cloud.model.Download;
import com.cloud.model.Resource;
import com.cloud.model.User;
import com.cloud.service.DownloadServiceI;


@Service("downloadService")
public class DownloadServiceImpl implements DownloadServiceI {

	private DownloadMapper downloadMapper;
	
	
	public DownloadMapper getDownloadMapper() {
		return downloadMapper;
	}
	@Autowired
	public void setDownloadMapper(DownloadMapper downloadMapper) {
		this.downloadMapper = downloadMapper;
	}
	@Override
	public int addDownloadLog(Download download) {
		return downloadMapper.insertSelective(download);
	}
	@Override
	public int deleteDownloadLog(int downloadId) {
		return downloadMapper.deleteByPrimaryKey(downloadId);
	}
	@Override
	public Download getDownloadById(int downloadId) {
		return downloadMapper.selectByPrimaryKey(downloadId);
	}
	@Override
	public List<User> getResourceDownloadUsers(int resourceId) {
		return downloadMapper.getResourceDownloadUsers(resourceId);
	}
	@Override
	public List<Resource> getUserDownloadResources(int userId) {
		return downloadMapper.getUserDownloadResources(userId);
	}
}
