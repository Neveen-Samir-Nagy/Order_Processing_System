package Model;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Customers {

	void edit_Information(User u, String current_name) throws SQLException;

	ResultSet search_ForBooks(Book b);

	ResultSet view_Individual_TotalPrices();

	void checkOut(ResultSet books);
		
	void confirm_order(String ISBN);
	
	void comp_trans(String ISBN, int q);
}

