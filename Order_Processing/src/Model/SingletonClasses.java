package Model;

public class SingletonClasses {
	public SignInAndUp sign;
	public Customer customer;
	public Manager manager;
	private static SingletonClasses GG = null;
	private static String book = "";
	private static String column = "";
	private static String value = "";
	public User my_user;
	 private SingletonClasses() {
		// TODO Auto-generated constructor stub
		sign = new SignInAndUp();
		customer = new Customer();
		manager = new Manager();
		my_user = new User(null,null,null,null,null,null,null,false);
	}
	
	public static SingletonClasses getoneclass() {
		if(GG==(null)) {
			GG=new SingletonClasses();
		}
		return GG;
	}
	
	public static String get_book() {
		return book;
	}
	public static void set_book(String type) {
		book = type;
	}
	public static String get_column_book() {
		return column;
	}
	public static void set_column_book(String type) {
		column = type;
	}
	public static String get_value_book() {
		return value;
	}
	public static void set_valye_book(String type) {
		value = type;
	}
}
