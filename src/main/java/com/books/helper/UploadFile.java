package com.books.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile 
{
	public final String path = "C:\\Users\\hp\\eclipse-workspaceSpringBoot\\BootRestAPIBooks\\src\\main\\resources\\static\\Images";
	
	public boolean upload(MultipartFile f)
	{
		boolean flag = false;
		
		try
		{
//			converting file data into InputStream
			InputStream is = f.getInputStream();
//			intializing byte array to store InputStream
			byte data[] = new byte[is.available()];
//			reading file from inputStream to byte array
			is.read(data);
//			setting path to save the file
			FileOutputStream fos = new FileOutputStream(path+File.pathSeparator+f.getOriginalFilename());
//			saving the file to the desired path
			fos.write(data);
//			closing resources
			fos.flush();
			fos.close();
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	

}
