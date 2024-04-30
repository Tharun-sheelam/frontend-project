package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;


public class Bookservices implements bookrepository {
private HashMap<Integer,Book> hmap=new HashMap<>();
int uniqueid=3;

public Bookservices() {
Book b1=new Book(1,"harrypotter","https://img.freepik.com/free-vector/world-environment-day-paper-style-background_23-2149394152.jpg?w=996&t=st=1713247970~exp=1713248570~hmac=22684293326eb739b604e027981c1b47dd94bf292f7d8d8aa996597d7c8eb4da");
Book b2=new Book(2,"demo","https://img.freepik.com/free-photo/sphere-with-trees_1048-2609.jpg?w=740&t=st=1713248268~exp=1713248868~hmac=6c4024744bf2f9b9da51550e58519c59717692fb07de5183a2685b30e309715b");
hmap.put(b1.getid(),b1);
hmap.put(b2.getid(),b2);
}
@Override
public ArrayList<Book> getbooks()
{
	Collection<Book> collectionbooks=hmap.values();
	ArrayList<Book> books =new ArrayList<>(collectionbooks);
	return books;
}
@Override
public Book getbook(int bookid)
{
	Book book=hmap.get(bookid);
	if(book==null) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	return book;
}
			@Override
			public Book addbook(Book book) {
				
				book.setid(uniqueid);
				hmap.put(uniqueid,book);
				++uniqueid;
				return book;
				
			}
			@Override
			public Book updatebook(int bookid, Book book) {
				Book existingbook =hmap.get(bookid);
				book.setName(book.getname());
				if(existingbook==null) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				}
				if(existingbook!=null) {
					existingbook.setName(book.getname());
				}
					if(book.getimgurl()!=null) {
						existingbook.setImgUrl(book.getimgurl());
					}
				
				return existingbook;
			}
			@Override
			public void deletebook(int bookid) {
				Book deletebook=hmap.get(bookid);
				if(deletebook==null) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				}
				else {
					hmap.remove(bookid);
					throw new ResponseStatusException(HttpStatus.NO_CONTENT);
				}
			}

}