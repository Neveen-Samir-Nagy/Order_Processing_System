package Model;

public interface Sign_INAndUP {

	boolean sign_UP(String Username, String Password, String Firstname, String Lastname, String PhoneNumber, 
			String EmailAddress, String ShippingAddress, String Type);

	boolean sign_IN(String Username, String Password, String Type);
	
	void log_Out();
}
