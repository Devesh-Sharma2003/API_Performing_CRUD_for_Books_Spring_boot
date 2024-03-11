package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.books.helper.UploadFile;

@RestController
public class FileUploadController 
{
	@Autowired
	private UploadFile uploadfile;
	
	
	@PostMapping("/file")
	public ResponseEntity<String> fileUploadHandler(@RequestParam("file") MultipartFile f)
	{
		if(f.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("File is Empty!!");
		}
		
		
		if(!f.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.METHOD_FAILURE).body("File must be in JPEG format!!");		
		}
		
		try
		{
			boolean flag = uploadfile.upload(f);
			if(flag)
			{
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("File has been uplaoded seuccessfully!! : "+f.getOriginalFilename());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!!");
	}
}
