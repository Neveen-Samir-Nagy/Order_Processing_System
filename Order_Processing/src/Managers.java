import java.util.Queue;

public interface Managers {

	void add_NewBook(String ISBN, String Title, String Publisher, String Author, String year, String price);

	void modify_ExistingBook(String column, String value, Queue update_columns, Queue update_values);

	void place_OrdersForBooks();

	void promote_RegisteredCustomersToHaveManagersCredentials();

	void view_GroupingOnSales();
}
