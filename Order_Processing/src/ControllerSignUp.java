import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
		boolean result = sign.sign_UP(usernameText.getText(), passwordText.getText(), firstnameText.getText(),
				lastnameText.getText(), phoneText.getText(), emailText.getText(), shippingText.getText(),
				typeText.getText());
		if(result) {
			if(typeText.getText().toLowerCase().equals("customer")) {
				Parent loader = FXMLLoader.load(getClass().getResource("CustomerFXML.fxml"));
				Scene scene = new Scene(loader);
				Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				app.setScene(scene);
				app.show();
			}else if(typeText.getText().toLowerCase().equals("manager")) {
				Parent loader = FXMLLoader.load(getClass().getResource("ManagerFXML.fxml"));
				Scene scene = new Scene(loader);
				Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				app.setScene(scene);
				app.show();
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Error! This Account is already existed");
			alert.showAndWait();
		}
	}
}
