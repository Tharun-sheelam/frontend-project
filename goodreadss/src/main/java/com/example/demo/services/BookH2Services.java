package com.example.demo.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.model.BookRowMapper;

@Service
public class BookH2Services implements BookRepository{
	@Autowired
    private JdbcTemplate db;
	@Override
	public List<Book> getbooks(){
	List<Book> listBooks=db.query("select * from Book", new BookRowMapper());
	//ArrayList<Book> books =new ArrayList<>(listBooks);
	return listBooks;
	}
	@Override
	public Book getbook(int id) {
		try {
		Book book=db.queryForObject("select * from Book where id=?",new BookRowMapper(),id);
		return book;
	}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
			
		
		}
	@Override
	public Book addbook(Book book) {
	db.update("insert into Book(name,imageurl) values(?,?)",book.getname(),book.getimgurl());
		Book bookadded=db.queryForObject("select * from Book where imageUrl=?",new BookRowMapper(),book.getimgurl());
		return bookadded;
	}
	@Override
	public Book updatebook(int bookid, Book book) {
		if(book.getname()!=null) {
			db.update("update Book set name=?  where id=?",book.getname(),bookid);
		}
		if(book.getimgurl()!=null) {
			db.update("update book set imageUrl=? where id=?",book.getimgurl(),bookid);		
			}
		return getbook(bookid);
	}
	@Override
	public void deletebook(int bookid) {
	db.update("delete from book where id=?",bookid);
	}
}
