package com.cloud.model;

public class Folder {
    private Integer folderId;

    private String folderName;

    private Integer parentId;

    private Integer userId;
    
    private String date;
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getfolderId() {
        return folderId;
    }

    public void setfolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getfolderName() {
        return folderName;
    }

    public void setfolderName(String folderName) {
        this.folderName = folderName == null ? null : folderName.trim();
    }

    public Integer getparentId() {
        return parentId;
    }

    public void setparentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getuserId() {
        return userId;
    }

    public void setuserId(Integer userId) {
        this.userId = userId;
    }
}