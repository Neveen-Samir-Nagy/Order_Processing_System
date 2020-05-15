package Model;

public class Book {

	private String title, author, publisher, publication_year, category,ISBN;
	private int price,Quantity,Threshold;
	public Book(String ISBN, String title, String author, String publisher, String publication_year, int price,
			String category, int Quantity, int Threshold, String publisher_address, String publisher_phone) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.publication_year = publication_year;
		this.publisher = publisher;
		this.Quantity= Quantity;
		this.Threshold = Threshold;
	}

	public String get_ISBN() {
		return ISBN;
	}

	public int get_price() {
		return price;
	}
	public int get_Quantity() {
		return Quantity;
	}
	public int get_Threshold() {
		return Threshold;
	}
	public String get_title() {
		return title;
	}

	public String get_author() {
		return author;
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

	public void set_ISBN(String isbn) {
		ISBN = isbn;
	}

	public void set_price(int p) {
		price = p;
	}
	public void set_Quantity(int q) {
		Quantity = q;
	}
	public void set_Threshold(int t) {
		Threshold = t;
	}
	public void set_title(String t) {
		title = t;
	}

	public void set_author(String a) {
		author = a;
	}

	public void set_publisher(String p) {
		publisher = p;
	}

	public void set_publication_year(String y) {
		publication_year = y;
	}

	public void set_category(String c) {
		category = c;
	}

}