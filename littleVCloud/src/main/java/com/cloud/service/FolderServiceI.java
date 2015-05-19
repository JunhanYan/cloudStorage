package com.cloud.service;

import java.util.List;

import com.cloud.model.Folder;


public interface FolderServiceI {
	
	int deleteFolderById(Integer folderId);

    //int insert(Folder record);

    int newFolder(Folder record);

    Folder getFolderById(Integer folderId);
    List<Folder> getFolderByParentAndUser(int parentId,int userId);

    int modifyFolder(Folder record);

   // int updateByPrimaryKey(Folder record);

}
