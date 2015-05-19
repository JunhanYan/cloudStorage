package com.cloud.hdfs;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.File;
import java.io.IOException;
public class HDFSOperation {
	
	 private Configuration conf =null;
	// private static final String HADOOP_URL="hdfs://localhost:9000";
	    public HDFSOperation(){
	        conf =new Configuration();
	        conf.addResource(new Path("/home/junhan/hadoop/hadoop-2.6.0/etc/hadoop/core-site.xml"));
	    }
	    public HDFSOperation(Configuration conf){
	        this.conf =conf;
	    }
	
	public boolean sendFile(String path,String localfile){
	        File file=new File(localfile);
	        if (!file.isFile()) {
	           // System.out.println(file.getName());
	            return false;
	        }
	        try {
	            FileSystem localFS =FileSystem.getLocal(conf);
	            FileSystem hadoopFS =FileSystem.get(conf);
	            
	            Path hadPath=new Path(path);
	            FSDataOutputStream fsOut=hadoopFS.create(new Path(path+"/"+file.getName()));
	            FSDataInputStream fsIn=localFS.open(new Path(localfile));
	            byte[] buf =new byte[1024];
	            int readbytes=0;
	           
	            while ((readbytes=fsIn.read(buf))>0){
	                fsOut.write(buf,0,readbytes);
	            }
	            fsIn.close();
	            fsOut.close();
	            FileStatus[] hadfiles= hadoopFS.listStatus(hadPath);
	            for(FileStatus fs :hadfiles){
	                System.out.println(fs.toString());
	            }
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	  public boolean delFile(String hadfile){
	        try {
	            FileSystem hadoopFS =FileSystem.get(conf);
	            Path hadPath=new Path(hadfile);
	            Path p=hadPath.getParent();
	            boolean rtnval= hadoopFS.delete(hadPath, true);
	            FileStatus[] hadfiles= hadoopFS.listStatus(p);
	            for(FileStatus fs :hadfiles){
	                System.out.println(fs.toString());
	            }
	            return rtnval;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public boolean downloadFile(String hadfile,String localPath){
	        try {
	            FileSystem localFS =FileSystem.getLocal(conf);
	            FileSystem hadoopFS =FileSystem.get(conf);
	            Path hadPath=new Path(hadfile);
	            FSDataOutputStream fsOut=localFS.create(new Path(localPath+"/"+hadPath.getName()));
	            FSDataInputStream fsIn=hadoopFS.open(hadPath);
	            byte[] buf =new byte[1024];
	            int readbytes=0;
	            while ((readbytes=fsIn.read(buf))>0){
	                fsOut.write(buf,0,readbytes);
	            }
	            fsIn.close();
	            fsOut.close();
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	

}
