import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ControllerSignIn {

	@FXML
	Button log_in = new Button();
	
	@FXML
	Label sign_in = new Label();
	
	@FXML
	Label userName = new Label();
	
	@FXML
	Label password = new Label();
	
	@FXML
	Label type = new Label();
	
	@FXML
	TextField user_name = new TextField();
	
	@FXML
	TextField pass = new TextField();
	
	@FXML
	TextField Type = new TextField();
	
	SignInAndUp sign = new SignInAndUp();
	
	public void Sign_in(ActionEvent event) throws IOException{
		System.out.println(sign.sign_IN(user_name.getText(), pass.getText(), Type.getText()));
	}
}
