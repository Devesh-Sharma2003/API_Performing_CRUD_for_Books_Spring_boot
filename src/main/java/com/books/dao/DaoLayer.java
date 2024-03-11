package com.books.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.books.bean.Book;

@Repository
public interface DaoLayer extends CrudRepository<Book, Integer>
{
}
