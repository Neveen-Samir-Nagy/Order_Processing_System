package Model;
import java.sql.ResultSet;
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
	public ResultSet search_ForBooks(String columnName, String value) {
		// TODO Auto-generated method stub
		ResultSet result_search = null;
		return result_search;
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

}
