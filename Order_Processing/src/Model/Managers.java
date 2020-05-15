package Model;
import java.util.Queue;

public interface Managers {

	void add_NewBook(Book b);

	void modify_ExistingBook(String ISBN, Book b);

	void view_GroupingOnSales();

	void user_to_manager(String name);

	void add_author(String ISBN, String name);
	
	void add_publisher(String name, String address, String phone);
}