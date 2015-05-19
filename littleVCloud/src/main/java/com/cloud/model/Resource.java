package com.cloud.model;

public class Resource {
    private Integer resourceId;

    private String resourceName;

    private String type;

    private String path;

    private String description;

    private Integer uploaderId;

    private String uploadTime;

    private Integer downloadTimes;

    private Integer status;
    
    private int folderId;
    
    private int process;

    private int size;
    
    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getfFlderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceid) {
        this.resourceId = resourceid;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourcename) {
        this.resourceName = resourcename == null ? null : resourcename.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Integer uploaderid) {
        this.uploaderId = uploaderid;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadtime) {
        this.uploadTime = uploadtime == null ? null : uploadtime.trim();
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadtimes) {
        this.downloadTimes = downloadtimes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}