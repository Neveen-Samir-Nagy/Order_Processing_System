package Model;
import java.util.Queue;

public interface Managers {

	void add_NewBook(String ISBN, String Title, String Publisher_name, String Author, String year,
			String price, String publisher_address, String publisher_phone);

	void modify_ExistingBook(String column, String value, Queue update_columns, Queue update_values);

	void place_OrdersForBooks();

	void promote_RegisteredCustomersToHaveManagersCredentials();

	void view_GroupingOnSales();

	void user_to_manager(String name);

	void add_author(String ISBN, String name);
}
