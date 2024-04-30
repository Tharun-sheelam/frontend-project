package com.example.demo.repository;

//import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Book;


public interface BookRepository {
	List<Book> getbooks();
	Book getbook(int id);
	Book addbook(Book book);
	Book updatebook(int bookid, Book book);
	void deletebook(int bookid);
}
