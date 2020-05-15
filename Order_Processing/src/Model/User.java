package Model;

public class User {

	private String userName, password, email, shippingAddress, phone, firstName, lastName;
	boolean type;
	
	public User(String userName, String password, String firstName, String lastName, String email, String phone,
			String shippingAddress, boolean type) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.shippingAddress = shippingAddress;
		this.type = type;
	}
	
	public void set_userName(String str) {
		userName = str;
	}
	
	public String get_userName() {
		return userName;
	}
	
	public void set_password(String str) {
		password = str;
	}
	
	public String get_password() {
		return password;
	}
	public void set_firstName(String str) {
		firstName = str;
	}
	
	public String get_firstName() {
		return firstName;
	}
	public void set_lastName(String str) {
		lastName = str;
	}
	
	public String get_lastName() {
		return lastName;
	}
	public void set_Email(String str) {
		email = str;
	}
	
	public String get_Email() {
		return email;
	}
	public void set_phone(String str) {
		phone = str;
	}
	
	public String get_phone() {
		return phone;
	}
	public void set_shippingAddress(String str) {
		shippingAddress = str;
	}
	
	public String get_shippingAddress() {
		return shippingAddress;
	}
	public void set_type(boolean str) {
		type = str;
	}
	
	public boolean get_type() {
		return type;
	}
}
