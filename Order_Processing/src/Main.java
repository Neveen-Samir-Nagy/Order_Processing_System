
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      SignInAndUp s = new SignInAndUp();
      System.out.println(s.sign_UP("Neveen_Samir", "1234", "Neveen", "Samir", "01234", "neveen@gmail.com", "EhDa", "Manager"));
      System.out.println(s.sign_UP("Febronia_Ashraf", "1234", "Febronia", "Ashraf", "01234", "Feby@gmail.com", "EhDa", "Manager"));
      System.out.println(s.sign_IN("Neveen_Samir", "1234", "Manager"));
      System.out.println(s.sign_IN("Febronia_Ashraf", "123", "Manager"));
	}

}
