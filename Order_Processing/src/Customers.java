import java.sql.ResultSet;
import java.sql.SQLException;

public interface Customers {

	void edit_Information(String Username, String Password, String Firstname, String Lastname, String PhoneNumber, 
			String EmailAddress, String ShippingAddress, String Type) throws SQLException;

	ResultSet search_ForBooks(Book b);

	ResultSet view_Individual_TotalPrices();

	void checkOut(ResultSet books);

	ResultSet get_profile();
	
	void add_order(String ISBN, int q);
	
	void confirm_order(String ISBN);
}
