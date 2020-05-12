
public class SingletonClasses {
	SignInAndUp sign;
	Customer customer;
	Manager manager;
	private static SingletonClasses GG = null;
	 private SingletonClasses() {
		// TODO Auto-generated constructor stub
		sign = new SignInAndUp();
		customer = new Customer();
		manager = new Manager();
	}
	
	public static SingletonClasses getoneclass() {
		if(GG==(null)) {
			GG=new SingletonClasses();
		}
		return GG;
	}
}
