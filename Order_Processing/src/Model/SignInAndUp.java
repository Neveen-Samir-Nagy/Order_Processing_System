package Model;
import java.sql.ResultSet;

public class SignInAndUp implements Sign_INAndUP {

	@Override
	public boolean sign_UP(String Username, String Password, String Firstname, String Lastname, String PhoneNumber,
			String EmailAddress, String ShippingAddress, String Type) {
		// TODO Auto-generated method stub
		ResultSet new_user = null;
		return false;
	}

	@Override
	public boolean sign_IN(String Username, String Password, String Type) {
		// TODO Auto-generated method stub
		ResultSet user = null;
		return false;
	}

	@Override
	public void log_Out() {
		// TODO Auto-generated method stub
	}
}
