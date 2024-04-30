package com.example.demo;

public class Book {
	private int id;
	private String name;
	private String imgurl;
	public Book(int id, String name, String imgurl) {
		this.id=id;
		this.name=name;
		this.imgurl=imgurl;
	}
public int getid()
{
	return id;
}
public String getname()
{
	return name;
}
public String getimgurl()
{
	return imgurl;
}
public void setid(int id) {
	this.id=id;
}
public void setName(String name) {
	this.name=name;
}
public  void setImgUrl(String imgUrl) {
	this.imgurl=imgUrl;
}
}
