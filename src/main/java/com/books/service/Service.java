package com.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.stereotype.Service;
import com.books.bean.Book;
import com.books.dao.AuthorDao;
import com.books.dao.DaoLayer;



@org.springframework.stereotype.Service
public class Service 
{
//	private static List<Book> li = new ArrayList<Book>();
//	
//	static
//	{
//		li.add(new Book(9811,"Think by Brain","Roald Dahl"));
//		li.add(new Book(7011,"Ragneesh Earth","vinci"));
//		li.add(new Book(9654,"The Mother","Khanna"));
//		li.add(new Book(6783,"The BollyWood","Dharma Production"));
//	}
	
	@Autowired
	private DaoLayer dao;
	
	@Autowired
	private AuthorDao ad;
	
	public List<Book> getAllBooks()
	{
		List<Book> li = (List) this.dao.findAll();
		return li;
	}
	
	public Book getBook(int id)
	{
		Optional <Book> b = this.dao.findById(id);
		if(b.isPresent())
		{
			Book bo = b.get();
			return bo;
		}
		else
		{
			return null;
		}
	}
	
	public Book addBook(Book b)
	{
		Book bo = this.dao.save(b);
		return bo;
	}

	public void deleteBook(int id) 
	{
		this.dao.deleteById(id);
	}

	public Book updateBook(Book book, int id) 
	{
		Optional<Book> b = this.dao.findById(id);
		Book bo = b.get();
		int a_id = bo.getAuthor().getId();
		book.setId(id);
		System.out.println(a_id);
		this.ad.deleteById(a_id);
		Book boo = this.dao.save(book);
		return boo;
	}

}




