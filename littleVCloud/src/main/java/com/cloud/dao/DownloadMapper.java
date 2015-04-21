package com.cloud.dao;

import com.cloud.model.Download;

public interface DownloadMapper {
    int deleteByPrimaryKey(Integer downloadid);

    int insert(Download record);

    int insertSelective(Download record);

    Download selectByPrimaryKey(Integer downloadid);

    int updateByPrimaryKeySelective(Download record);

    int updateByPrimaryKey(Download record);
}