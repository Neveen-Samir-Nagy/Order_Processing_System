import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignInAndUp implements Sign_INAndUP {

	@Override
	public boolean sign_UP(String Username, String Password, String Firstname, String Lastname, String PhoneNumber,
			String EmailAddress, String ShippingAddress, String Type) {
		// TODO Auto-generated method stub
		BufferedWriter myWriter = null;
		BufferedReader myReader = null;
		String[] words = null;
		boolean result = true;
		try {
			myWriter = new BufferedWriter(new FileWriter("Users.txt", true));
			myReader = new BufferedReader(new FileReader("Users.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String read = "";
			while ((read = myReader.readLine()) != null) // Reading Content from the file
			{
				words = read.split("[ |]+");
				if (words[0].toLowerCase().equals(Type) && words[1].equals(Username) && words[3].equals(EmailAddress)) {
					result = false;
				}
			}
			if (result) {
				myWriter.write(Type + " | " + Username + " | " + Password + " | " + EmailAddress + " | " + Firstname
						+ " | " + Lastname + " | " + PhoneNumber + " | " + ShippingAddress);
				myWriter.newLine();
				myWriter.close();
				myReader.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean sign_IN(String Username, String Password, String Type) {
		// TODO Auto-generated method stub
		BufferedReader myReader = null;
		String[] words = null;
		boolean result = false;
		try {
			myReader = new BufferedReader(new FileReader("Users.txt"));
			String read = "";
			while ((read = myReader.readLine()) != null) // Reading Content from the file
			{
				words = read.split("[ |]+");
				if (words[0].toLowerCase().equals(Type) && words[1].equals(Username) && words[2].equals(Password)) {
					result = true;
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}

	@Override
	public void log_Out() {
		// TODO Auto-generated method stub

	}
}
