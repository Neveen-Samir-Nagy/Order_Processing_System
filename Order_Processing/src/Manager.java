import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Queue;

public class Manager implements Managers{

	@Override
	public void add_NewBook(String ISBN, String Title, String Publisher, String Author, String year, String price) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void modify_ExistingBook(String column, String value, Queue update_columns, Queue update_values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void place_OrdersForBooks() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void promote_RegisteredCustomersToHaveManagersCredentials() {
		// TODO Auto-generated method stub
		
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
}
