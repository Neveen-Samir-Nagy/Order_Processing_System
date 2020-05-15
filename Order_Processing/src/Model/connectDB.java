package Model;
import java.sql.*;

public class connectDB {
	private static connectDB db = null;
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    CallableStatement cstmt = null;
	private connectDB() throws SQLException  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
	                   .getConnection("jdbc:mysql://localhost/bookstore"
	                           + "root" + "root");
		    statement = connect.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    }
	public static connectDB get_instance() {
		if(db == null) {
			try {
				db = new connectDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return db;
	}
	public ResultSet execute_query(String q) throws SQLException {
		 resultSet = statement.executeQuery(q);
		 return resultSet;
	}
	 public ResultSet execute_procedure(CallableStatement statement) {
	        try {

	            resultSet = statement.executeQuery();

	        } catch (Exception ex) {
	            System.out.println(ex);
	        }
	        return resultSet;
	    }
	 public Connection get_connection() {
		 return connect;
	 }
	  public void closeConnection() {
	        try {
	            connect.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	

	

}
