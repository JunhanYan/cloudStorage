package com.cloud.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    
        this.doPost(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
          
     
            String fileName = req.getParameter("file");
           
            OutputStream out = resp.getOutputStream();
        
            byte[] b = new byte[1024];
        
            File file = new File("/home/junhan/tmp/"+fileName);
            
            resp.reset();
            
            resp.setHeader("Content-Disposition", "attachment; filename=" +fileName);

            long fileLength = file.length();  
            String length = String.valueOf(fileLength);  

            resp.setHeader("Content-Length", length);  
        
            resp.setContentType("application/octet-stream");
            FileInputStream in = new FileInputStream(file);
            
            int n = 0;
           
            while((n = in.read(b)) != -1) {
                
                out.write(b, 0, n);
          
            } 
            in.close();
            out.flush();
            out.close();
    }

}
