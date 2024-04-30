package com.example.demo;

import java.util.ArrayList;

public interface bookrepository {
	ArrayList<Book> getbooks();
	Book getbook(int id);
	Book addbook(Book book);
	Book updatebook(int bookid, Book book);
	void deletebook(int bookid);

}
