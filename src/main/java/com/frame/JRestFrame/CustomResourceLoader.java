package com.frame.JRestFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.File;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
 
public class CustomResourceLoader implements ResourceLoaderAware {
 
    private ResourceLoader resourceLoader;
 
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
 
    public void showResourceData() throws IOException
    {
        //This line will be changed for all versions of other examples
        Resource banner = resourceLoader.getResource("file:QueryMap.json");
        InputStream in = banner.getInputStream();
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        reader.close();
    }
    
    public File getFile() throws IOException{
        
         Resource banner = resourceLoader.getResource("file:QueryMap.json");
         File file = banner.getFile();
        
         return file;
    }
    
    public File getFile(String filename) throws IOException{
        
         Resource banner = resourceLoader.getResource("file:"+filename);
         File file = banner.getFile();
        
         return file;
    }
    
    
}