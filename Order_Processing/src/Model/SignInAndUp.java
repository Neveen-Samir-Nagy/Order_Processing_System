package Model;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInAndUp implements Sign_INAndUP {

	@Override
	public void sign_up(User u) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();
		String query = "{CALL Sign_UP(?,?,?,?,?,?,?,?)}";
		ResultSet set = null;
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
			set = statement.executeQuery();
			connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	@Override
	public ResultSet sign_in(String name, String password, String type) {
		// TODO Auto-generated method stub
		connectDB connect = connectDB.get_instance();
		String query = "{CALL Sign_IN(?,?,?)}";
		ResultSet set = null;
		CallableStatement statement;
		try {
			connect.get_connection().setAutoCommit(false);
			statement = connect.get_connection().prepareCall(query);
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, type);
			set = statement.executeQuery();
			connect.get_connection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return set;
	}
}
