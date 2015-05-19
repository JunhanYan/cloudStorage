package com.cloud.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.dao.FolderMapper;
import com.cloud.model.Folder;
import com.cloud.service.FolderServiceI;


@Service("folderService")
public class FolderServiceImpl implements FolderServiceI {

	public FolderMapper folderMapper;
	
	public FolderMapper getFolderMapper() {
		return folderMapper;
	}
	@Autowired
	public void setFolderMapper(FolderMapper folderMapper) {
		this.folderMapper = folderMapper;
	}
	@Override
	public int newFolder(Folder record) {
		
		return folderMapper.insertSelective(record);
	}
	@Override
	public int modifyFolder(Folder record) {
		return folderMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int deleteFolderById(Integer folderId) {
		return folderMapper.deleteByPrimaryKey(folderId);
	}
	@Override
	public Folder getFolderById(Integer folderId) {
		return folderMapper.selectByPrimaryKey(folderId);
	}
	@Override
	public List<Folder> getFolderByParentAndUser(int parentId, int userId) {
		return folderMapper.getFolderByParentAndUser(parentId, userId);
	}
}
