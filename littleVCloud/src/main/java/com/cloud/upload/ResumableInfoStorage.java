package com.cloud.upload;

import java.io.*;
import java.util.HashMap;


public class ResumableInfoStorage {

    //Single instance
    private ResumableInfoStorage() {
    }
    private static ResumableInfoStorage sInstance;

    public static synchronized ResumableInfoStorage getInstance() {
        if (sInstance == null) {
            sInstance = new ResumableInfoStorage();
        }
        return sInstance;
    }

    //resumableIdentifier --  ResumableInfo
    private HashMap<String, ResumableInfo> mMap = new HashMap<String, ResumableInfo>();

    
    public synchronized ResumableInfo get(int resumableChunkSize, long resumableTotalSize,
                             String resumableIdentifier, String resumableFilename,
                             String resumableRelativePath, String resumableFilePath) {

        ResumableInfo info = mMap.get(resumableIdentifier);

        if (info == null) {
            info = new ResumableInfo();

            info.resumableChunkSize     = resumableChunkSize;
            info.resumableTotalSize     = resumableTotalSize;
            info.resumableIdentifier    = resumableIdentifier;
            info.resumableFilename      = resumableFilename;
            info.resumableRelativePath  = resumableRelativePath;
            info.resumableFilePath      = resumableFilePath;

            mMap.put(resumableIdentifier, info);
        }
        return info;
    }

    /**
     * ResumableInfo
     * @param info
     */
    public void remove(ResumableInfo info) {
       mMap.remove(info.resumableIdentifier);
    }
}
