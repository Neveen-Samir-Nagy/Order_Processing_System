package Model;

import java.sql.*;
import java.sql.SQLException;

public class Customer implements Customers {

	@Override
	public void edit_Information(User u, String current_name) throws SQLException {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();
		ResultSet set = null;
		String query = "{CALL Update_User(?,?,?,?,?,?,?,?,?)}";
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
			statement.setString(7, u.get_shippingAddress());
			statement.setString(8, u.get_type());
			statement.setString(9, current_name);
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

}