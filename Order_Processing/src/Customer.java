import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class Customer implements Customers {


	@Override
	public void edit_Information(String Username, String Password, String Firstname, String Lastname, String PhoneNumber, 
			String EmailAddress, String ShippingAddress, String Type)  throws SQLException{
		// TODO Auto-generated method stub
		ResultSet myProfile = get_profile();
		Queue<String> columns = new LinkedList<String>();
		Queue<String> values = new LinkedList<String>();
		if(Username != myProfile.getString("UserName")) {
			columns.add("UserName");
			values.add(Username);
		}
		if(Password != myProfile.getString("Password")) {
			columns.add("Password");
			values.add(Password);
		}
		if(Firstname != myProfile.getString("FirstName")) {
			columns.add("FirstName");
			values.add(Firstname);
		}
		if(Lastname != myProfile.getString("LastName")) {
			columns.add("LastName");
			values.add(Lastname);
		}
		if(PhoneNumber != myProfile.getString("Phone")) {
			columns.add("Phone");
			values.add(PhoneNumber);
		}
		if(EmailAddress != myProfile.getString("Email")) {
			columns.add("Email");
			values.add(EmailAddress);
		}
		if(ShippingAddress != myProfile.getString("Shipping_Address")) {
			columns.add("Shipping_Address");
			values.add(ShippingAddress);
		}
		while(!columns.isEmpty()) {
			
		}
	}

	@Override
	public ResultSet search_ForBooks(Book b) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();
		 ResultSet set = null;
		String query = "{CALL Search_Book(?,?,?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setInt(1, b.get_ISBN());
	        statement.setString(2, b.get_title());
	        statement.setString(3, b.get_category());
	        statement.setString(4, b.get_publisher());
	        set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	@Override
	public ResultSet view_Individual_TotalPrices() {
		// TODO Auto-generated method stub
		ResultSet view = null;
		return view;
	}

	@Override
	public void checkOut(ResultSet books) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet get_profile() {
		// TODO Auto-generated method stub
		ResultSet profile = null;
		return profile;
	}

	@Override
	public void add_order(String ISBN, int q) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();
		
		String query = "{CALL add_order(?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, ISBN);
	        statement.setInt(2, q);
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	}

	@Override
	public void confirm_order(String ISBN) {
		// TODO Auto-generated method stub
connectDB connect = connectDB.get_instance();
		
		String query = "{CALL confirm_order(?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, ISBN);
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		
	}

}
