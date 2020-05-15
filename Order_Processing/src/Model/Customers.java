package Model;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Customers {

	void edit_Information(User u) throws SQLException;

	ResultSet search_ForBooks(Book b);

	ResultSet view_Individual_TotalPrices();

	void checkOut(ResultSet books);

	ResultSet get_profile();
	
	void add_order(String ISBN, int q);
	
	void confirm_order(String ISBN);
	
	void comp_trans(String ISBN, int q);
	
	void sign_in(String name);
	
	void sign_up(String UserName ,String Password ,String firstName, String lastName ,String email ,String phone,
			String shipping_address , boolean type );
}
