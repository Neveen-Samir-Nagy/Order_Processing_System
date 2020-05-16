package Model;

import java.sql.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Queue;

public class Manager implements Managers{

	@Override
	public void add_NewBook(Book b) throws ParseException {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL AddBook(?,?,?,?,?,?,?,?)}";
		CallableStatement statement;
		try {
			java.util.Date uDate = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(uDate);
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, b.get_ISBN());
			statement.setString(2, b.get_title());
			statement.setString(3, b.get_category());
			statement.setString(4, b.get_publisher());
			statement.setLong(5, cal.get(Calendar.YEAR));
			statement.setInt(6, b.get_price());
			statement.setInt(7, b.get_Quantity());
			statement.setInt(8, b.get_Threshold());
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modify_ExistingBook(String ISBN, Book b) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL ModifyBook(?,?,?,?,?,?,?,?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, ISBN);
			statement.setString(2, b.get_ISBN());
			statement.setString(3, b.get_title());
			statement.setString(4, b.get_category());
			statement.setString(5, b.get_publisher());
			statement.setString(6, b.get_publication_year());
			statement.setInt(7, b.get_price());
			statement.setInt(8, b.get_Quantity());
			statement.setInt(9, b.get_Threshold());
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	@Override
	public void view_GroupingOnSales() {
		// TODO Auto-generated method stub

	}

	@Override
	public void user_to_manager(String name) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL user_to_manager(?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, name);
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 }

	@Override
	public void add_author(String ISBN, String name) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL add_author(?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, ISBN);
			statement.setString(2, name);
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void add_publisher(String name, String address, String phone) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL AddPublisher(?,?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, name);
			statement.setString(2, address);
			statement.setString(3, phone);
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
