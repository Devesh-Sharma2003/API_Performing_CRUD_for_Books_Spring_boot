package com.books.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.books.bean.Author;

@Repository
public interface AuthorDao extends CrudRepository<Author, Integer> 
{

}
