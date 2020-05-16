package Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.SingletonClasses;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerProfile implements Initializable {
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
	Label usernameText = new Label();
	@FXML
	Label passwordText = new Label();
	@FXML
	Label typeText = new Label();
	@FXML
	Label firstnameText = new Label();
	@FXML
	Label lastnameText = new Label();
	@FXML
	Label phoneText = new Label();
	@FXML
	Label emailText = new Label();
	@FXML
	Label shippingText = new Label();
	@FXML
	ImageView back = new ImageView();

	SingletonClasses s2 = SingletonClasses.getoneclass();

	public void done(MouseEvent event) throws IOException {
		Stage stage = (Stage) back.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
			usernameText.setText(s2.my_user.get_userName());
			firstnameText.setText(s2.my_user.get_firstName());
			lastnameText.setText(s2.my_user.get_lastName());
			emailText.setText(s2.my_user.get_Email());
			phoneText.setText(s2.my_user.get_phone());
			shippingText.setText(s2.my_user.get_shippingAddress());
		    typeText.setText(s2.my_user.get_type());
			passwordText.setText(s2.my_user.get_password());
	}
}
