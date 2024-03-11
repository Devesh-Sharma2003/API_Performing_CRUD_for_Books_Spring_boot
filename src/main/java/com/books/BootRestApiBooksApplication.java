package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootRestApiBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestApiBooksApplication.class, args);
	}
	
//	Always Remember these Http methods i.e which method is used for what purposes:
	
//	1.  GET: It is used to retrieve data from the database and send it back to the client...
//	2.  POST: It is used to create or add data in database recieved from client...
//	3.  PUT: It is used to update the data existing in database recieved from client...
//	4.  DELETE: It is used to delete the specified data from database as required by the client... 

}
