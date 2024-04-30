package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class bookcontroller {
	Bookservices b=new Bookservices();
	@GetMapping("/books")
	public ArrayList<Book> getbooks()
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
