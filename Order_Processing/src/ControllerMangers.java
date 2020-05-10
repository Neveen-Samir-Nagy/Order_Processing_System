import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControllerMangers {

	@FXML
	Button manager = new Button();
	@FXML
	Button edit = new Button();
	@FXML
	Button search = new Button();
	@FXML
	Button add = new Button();
	@FXML
	Button log_out = new Button();
	@FXML
	MenuButton manage = new MenuButton();
	@FXML
	MenuButton checkout = new MenuButton();
	
	public void options(ActionEvent event) throws IOException {
		
	}
	
    public void editInformation(ActionEvent event) throws IOException {
		
	}
	
	public void search_forBook(ActionEvent event) throws IOException {
		
	}
	
   public void add_Book(ActionEvent event) throws IOException {
	   
	}
   
   public void logOut(ActionEvent event) throws IOException {
	    Parent loader = FXMLLoader.load(getClass().getResource("Sign_IN.fxml"));
		Scene scene = new Scene(loader);
		Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		app.setScene(scene);
		app.show();
	}
    
   public void Manage1(ActionEvent event) throws IOException {
		
	}
   public void Manage2(ActionEvent event) throws IOException {
		
	}
   public void Manage3(ActionEvent event) throws IOException {
		
	}
   
   public void checkOut1(ActionEvent event) throws IOException {
		
	}
   public void checkOut2(ActionEvent event) throws IOException {
		
	}
}
