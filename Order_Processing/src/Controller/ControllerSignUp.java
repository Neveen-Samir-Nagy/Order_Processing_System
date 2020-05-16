package Controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.SingletonClasses;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerSignUp {
	ObservableList<String> typeItems = FXCollections.observableArrayList("Customer", "Manager");
	
	@FXML
	ImageView arrow = new ImageView();
	@FXML
	Button finish = new Button();
	@FXML
	Label registeration = new Label();
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
	ChoiceBox type = new ChoiceBox();
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
	Label hide = new Label();
	@FXML
	ImageView eye = new ImageView();
	
	SingletonClasses s2 = SingletonClasses.getoneclass();
	
	@FXML
	private void initialize() {
		type.setValue("Customer");
		type.setItems(typeItems);
	}

	public void Sign_UP(ActionEvent event) throws IOException, SQLException {
		ResultSet set = s2.sign.sign_in(usernameText.getText(), passwordText.getText(), type.getSelectionModel().getSelectedItem().toString());
		if(!set.next()) {
			s2.my_user = new User(usernameText.getText(), passwordText.getText(), firstnameText.getText(), lastnameText.getText(),
					emailText.getText(), phoneText.getText(), shippingText.getText(), type.getSelectionModel().getSelectedItem().toString());
			s2.sign.sign_up(s2.my_user);
			if(type.getSelectionModel().getSelectedItem().toString() == "Customer") {
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
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Error! This Account is already existed");
			alert.showAndWait();
		}
	}
	public void back(MouseEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("../View/Sign_IN.fxml"));
		Scene scene = new Scene(loader);
		Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		app.setScene(scene);
		app.show();
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
