import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerSignUp {

	@FXML
	Button done = new Button();
	@FXML
	Label sign_in = new Label();
	@FXML
	Label usernameLabel = new Label();
	@FXML
	Label passwordLabel = new Label();
	@FXML
	Label typeLabel = new Label();
	@FXML
	Label emailLabel = new Label();
	@FXML
	Label shippingLabel = new Label();
	@FXML
	Label phoneLabel = new Label();
	@FXML
	Label firstnameLabel = new Label();
	@FXML
	Label lastnameLabel = new Label();
	@FXML
	TextField usernameText = new TextField();
	@FXML
	TextField passwordText = new TextField();
	@FXML
	TextField typeText = new TextField();
	@FXML
	TextField firstnameText = new TextField();
	@FXML
	TextField lastnameText = new TextField();
	@FXML
	TextField phoneText = new TextField();
	@FXML
	TextField emailText = new TextField();
	@FXML
	TextField shippingText = new TextField();
	SignInAndUp sign = new SignInAndUp();

	public void Sign_UP(ActionEvent event) throws IOException {
		System.out.println(sign.sign_UP(usernameText.getText(), passwordText.getText(), firstnameText.getText(),
				lastnameText.getText(), phoneText.getText(), emailText.getText(), shippingText.getText(),
				typeText.getText()));
	}
}
