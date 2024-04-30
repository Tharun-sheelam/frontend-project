package com.example.demo.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.services.BookH2Services;
//import com.example.demo.services.BookServices;




@RestController

public class BookController {
	@Autowired
	public BookH2Services b;
	@GetMapping("/books")
	public List<Book> getbooks()
	{
		return b.getbooks();
	}
	@GetMapping("/books/{bookid}")
	public Book getbook(@PathVariable("bookid") int bookid) {
		return b.getbook(bookid);
	 
	
	}
	@PostMapping("/books")
	public Book addbook(@RequestBody Book book) {
		return b.addbook(book);
	}
	@PutMapping("/books/{bookid}")
	public Book updatebook(@PathVariable("bookid") int bookid,@RequestBody Book book) {
		return b.updatebook(bookid,book);
	}
    @DeleteMapping("/books/{bookid}")
    public void deletebook(@PathVariable("bookid") int bookid) {
    	b.deletebook(bookid);
    }



}




