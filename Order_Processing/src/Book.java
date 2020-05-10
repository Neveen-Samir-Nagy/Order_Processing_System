
public class Book {
	
	private int ISBN, price;
	private String title,  author,  publisher,  publication_year, category;
	
public Book(int ISBN, String title, String author, String publisher, String publication_year, int price, String category ) {
	this.ISBN = ISBN;
	this.title = title;
	this.author = author;
	this.category = category;
	this.price = price;
	this.publication_year = publication_year;
	this.publisher = publisher;
}

public int get_ISBN() {
	return ISBN; 
}
public int get_price() {
	return price; 
}
public String get_title() {
	return title; 
}
public String get_author() {
	return author ; 
}
public String get_publisher() {
	return publisher; 
}
public String get_publication_year() {
	return publication_year; 
}
public String get_category() {
	return category; 
}
public void set_ISBN(int isbn) {
	 ISBN = isbn; 
}
public void set_price(int p) {
	price =p; 
}
public void set_title(String t) {
	 title = t; 
}
public void set_author(String a) {
	author =a; 
}
public void set_publisher(String p) {
	 publisher =p; 
}
public void set_publication_year(String y) {
	 publication_year =y; 
}
public void set_category(String c) {
	 category =c; 
}

}
