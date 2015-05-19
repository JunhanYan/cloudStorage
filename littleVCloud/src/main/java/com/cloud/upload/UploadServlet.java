package com.cloud.upload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import com.cloud.hdfs.HDFSOperation;

public class UploadServlet extends HttpServlet {

    public static final String UPLOAD_DIR = "/home/junhan/upload";
   // private Configuration conf =null;
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int resumableChunkNumber        = getResumableChunkNumber(request);
       
        ResumableInfo info = getResumableInfo(request);
      /*  conf =new Configuration();
        conf.addResource(new Path("/home/junhan/hadoop/hadoop-2.6.0/etc/hadoop/core-site.xml"));
        conf .set("dfs.client.block.write.replace-datanode-on-failure.policy" ,"NEVER" );
        conf .set("dfs.client.block.write.replace-datanode-on-failure.enable" ,"true" );
        RandomAccessFile raf = new RandomAccessFile(info.resumableFilePath, "rw");
        long content_length = request.getContentLength();
        InputStream is = request.getInputStream();
        long readed = 0;
        byte[] bytes = new byte[1024 * 100];
        while(readed < content_length) {
            int r = is.read(bytes);
            if (r < 0)  {
                break;
            }
            raf.write(bytes, 0, r);
            readed += r;
        }
        try {
           
        	FileSystem hadoopFS =FileSystem.get(conf);
            
            Path hadPath=new Path(UPLOAD_DIR);
            Path filePath=new Path(info.resumableFilePath);
            FSDataOutputStream fsOut;
  
            byte[] buf =new byte[1024];
            int readbytes=0;
            if(hadoopFS.exists(filePath)){
            	fsOut=hadoopFS.append(filePath);
            	
            }else{
            	fsOut = hadoopFS.create(filePath);
            	
            }
           
          
           
            while ((readbytes=is.read(buf))>0){
                fsOut.write(buf,0,readbytes);
            }
            is.close();
            fsOut.close();
            FileStatus[] hadfiles= hadoopFS.listStatus(hadPath);
            for(FileStatus fs :hadfiles){
                System.out.println(fs.toString());
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }*/
       RandomAccessFile raf = new RandomAccessFile(info.resumableFilePath, "rw");

        //Seek to position
        raf.seek((resumableChunkNumber - 1) * (long)info.resumableChunkSize);

        //Save to file
        InputStream is = request.getInputStream();
        long readed = 0;
        long content_length = request.getContentLength();
        byte[] bytes = new byte[1024 * 100];
        while(readed < content_length) {
            int r = is.read(bytes);
            if (r < 0)  {
                break;
            }
            raf.write(bytes, 0, r);
            readed += r;
        }
        raf.close();

        

        //Mark as uploaded.
        info.uploadedChunks.add(new ResumableInfo.ResumableChunkNumber(resumableChunkNumber));
        if (info.checkIfUploadFinished()) { //Check if all chunks uploaded, and change filename
            System.out.println(info.resumableFilename);
            System.out.println(info.resumableFilePath);
            System.out.println(info.resumableRelativePath);
            System.out.println(info.resumableTotalSize);
        	System.out.println(request.getParameter("uploaderId"));
        	System.out.println(request.getParameter("uploadDate"));
            HDFSOperation hdfs=new HDFSOperation();
            hdfs.sendFile("/upload",info.resumableFilePath);
            if(deleteFile(info.resumableFilePath)){
            	ResumableInfoStorage.getInstance().remove(info);
            }else{
            	System.out.println("删除文件失败");
            }
            response.getWriter().print("All finished.");
        } else {
            response.getWriter().print("Upload");
        }
    }

    
    public boolean deleteFile(String sPath) {  
        boolean flag = false;  
        File file = new File(sPath);  
        // 路径为文件且不为空则进行删除  
        if (file.isFile() && file.exists()) { 
            file.delete();  
            flag = true;  
        }  
        return flag;  
    }  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int resumableChunkNumber        = getResumableChunkNumber(request);

        ResumableInfo info = getResumableInfo(request);

        if (info.uploadedChunks.contains(new ResumableInfo.ResumableChunkNumber(resumableChunkNumber))) {
            response.getWriter().print("Uploaded."); //This Chunk has been Uploaded.
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private int getResumableChunkNumber(HttpServletRequest request) {
        return HttpUtils.toInt(request.getParameter("resumableChunkNumber"), -1);
    }

    private ResumableInfo getResumableInfo(HttpServletRequest request) throws ServletException {
        String base_dir = UPLOAD_DIR;

        int resumableChunkSize          = HttpUtils.toInt(request.getParameter("resumableChunkSize"), -1);
        long resumableTotalSize         = HttpUtils.toLong(request.getParameter("resumableTotalSize"), -1);
        String resumableIdentifier      = request.getParameter("resumableIdentifier");
        String resumableFilename        = request.getParameter("resumableFilename");
        String resumableRelativePath    = request.getParameter("resumableRelativePath");
        //Here we add a ".temp" to every upload file to indicate NON-FINISHED
        String resumableFilePath        = new File(base_dir, resumableFilename).getAbsolutePath() + ".temp";

        ResumableInfoStorage storage = ResumableInfoStorage.getInstance();

        ResumableInfo info = storage.get(resumableChunkSize, resumableTotalSize,
                resumableIdentifier, resumableFilename, resumableRelativePath, resumableFilePath);
        if (!info.vaild())         {
            storage.remove(info);
            throw new ServletException("Invalid request params.");
        }
        return info;
    }
}
