package Model;

import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class Customer implements Customers {


	@Override
	public void edit_Information(User u)  throws SQLException{
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();
		 ResultSet set = null;
		String query = "{CALL Update_User(?,?,?,?,?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, u.get_userName());
	        statement.setString(2, u.get_password());
	        statement.setString(3, u.get_firstName());
	        statement.setString(4, u.get_lastName());
	        statement.setString(5, u.get_Email());
	        statement.setString(6, u.get_phone());
	        set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

	@Override
	public ResultSet search_ForBooks(Book b) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();
		 ResultSet set = null;
		String query = "{CALL Search_Book(?,?,?,?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, b.get_ISBN());
	        statement.setString(2, b.get_title());
	        statement.setString(3, b.get_category());
	        statement.setString(4, b.get_publisher());
	        statement.setString(5, b.get_author());
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

	@Override
	public void comp_trans(String ISBN, int q) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL comp_trans(?,?)}";
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
	public void sign_in(String name) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL Sign_IN(?)}";
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
	public void sign_up(String UserName, String Password, String firstName, String lastName, String email, String phone,
			String shipping_address, boolean type) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();

		String query = "{CALL Sign_UP(?,?,?,?,?,?,?,?)}";
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, UserName);
			statement.setString(2, Password);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setString(5, email);
			statement.setString(6, phone);
			statement.setString(7, shipping_address);
			statement.setBoolean(8, type);
	        ResultSet set = statement.executeQuery();
	        connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
