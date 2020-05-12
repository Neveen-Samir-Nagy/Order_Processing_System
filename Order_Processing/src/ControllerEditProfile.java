import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerEditProfile {
	@FXML
	Button done = new Button();
	@FXML
	Label profile = new Label();
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
	PasswordField passwordText = new PasswordField();
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
	@FXML
	ImageView eye = new ImageView();
	@FXML
	Label hide = new Label();
	
	SingletonClasses s2 = SingletonClasses.getoneclass();
	
	public void done(ActionEvent event) throws IOException {
		Stage stage = (Stage) done.getScene().getWindow();
	    stage.close();
	}
	public void show_password(MouseEvent event) {
		String get_pass = passwordText.getText();
		hide.setText(get_pass);
		if(hide.isVisible()) {
			hide.setVisible(false);
		}else {
			hide.setVisible(true);
		}
	}
}
