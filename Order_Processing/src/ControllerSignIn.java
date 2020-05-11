import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerSignIn {

	@FXML
	Button log_in = new Button();

	@FXML
	Button register = new Button();

	@FXML
	TextField user_name = new TextField();

	@FXML
	TextField pass = new TextField();

	@FXML
	TextField Type = new TextField();

	SignInAndUp sign = new SignInAndUp();
	ControllerCustomers cm = new ControllerCustomers();

	public void Sign_in(ActionEvent event) throws IOException {
		boolean result = true;
		if (result) {
			if(Type.getText().toLowerCase().equals("customer")) {
				Parent loader = FXMLLoader.load(getClass().getResource("CustomerFXML.fxml"));
				Scene scene = new Scene(loader);
				Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				app.setScene(scene);
				app.show();
			}else if(Type.getText().toLowerCase().equals("manager")) {
				Parent loader = FXMLLoader.load(getClass().getResource("ManagerFXML.fxml"));
				Scene scene = new Scene(loader);
				Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				app.setScene(scene);
				app.show();
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Error! This Account doesn't exist");
			alert.showAndWait();
		}
	}
	
	public void sign_UP(ActionEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("Sign_UP.fxml"));
		Scene scene = new Scene(loader);
		Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		app.setScene(scene);
		app.show();
	}
	
	
}
