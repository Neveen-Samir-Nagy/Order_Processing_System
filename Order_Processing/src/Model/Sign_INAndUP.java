package Model;

import java.sql.ResultSet;

public interface Sign_INAndUP {

    ResultSet sign_in(String name, String password, String type);
	
	void sign_up(User u);
}
