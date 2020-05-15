package Controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.SingletonClasses;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
	PasswordField pass = new PasswordField();

	@FXML
	TextField Type = new TextField();
	@FXML
	ImageView eye = new ImageView();

	@FXML
	Label hide = new Label();
	
	SingletonClasses s2 = SingletonClasses.getoneclass();

	public void Sign_in(ActionEvent event) throws IOException, SQLException {
		boolean type = false;
		if(Type.getText().toLowerCase().equals("manager")) {
			type = true;
		}
		ResultSet user = s2.sign.sign_in(user_name.getText(), pass.getText(), type);
		if (user.next()) {
			if(!type) {
				s2.my_user = new User(user.getString(1),user.getString(2),user.getString(3),user.getString(4),
						user.getString(5),user.getString(6),user.getString(7),user.getBoolean(8));
				Parent loader = FXMLLoader.load(getClass().getResource("../View/CustomerFXML.fxml"));
				Scene scene = new Scene(loader);
				Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				app.setScene(scene);
				app.show();
			}else {
				Parent loader = FXMLLoader.load(getClass().getResource("../View/ManagerFXML.fxml"));
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
		Parent loader = FXMLLoader.load(getClass().getResource("../View/Sign_UP.fxml"));
		Scene scene = new Scene(loader);
		Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		app.setScene(scene);
		app.show();
	}
	
	public void show_password(MouseEvent event) {
		String get_pass = pass.getText();
		hide.setText(get_pass);
		if(hide.isVisible()) {
			hide.setVisible(false);
		}else {
			hide.setVisible(true);
		}
	}
}
