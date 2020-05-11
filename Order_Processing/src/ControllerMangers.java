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
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControllerMangers {

	Button log_out = new Button();
	@FXML
	Menu edit = new Menu();
	@FXML
	Menu profile = new Menu();
	@FXML
	Menu insert = new Menu();
	@FXML
	Menu delete = new Menu();
	@FXML
	Menu view = new Menu();
	@FXML
	Menu help = new Menu();
	@FXML
	Menu search = new Menu();
	@FXML
	Menu update = new Menu();
	@FXML
	Menu category = new Menu();
	@FXML
	Menu add = new Menu();
	@FXML
	Menu modify = new Menu();
	@FXML
	Menu placeOrder = new Menu();
	@FXML
	Menu confirmOrder = new Menu();
	@FXML
	Menu viewReport = new Menu();
	@FXML
	MenuBar menu = new MenuBar();
	@FXML
	MenuItem editItem = new MenuItem();
	@FXML
	MenuItem profileItem = new MenuItem();
	@FXML
	MenuItem deleteItem = new MenuItem();
	@FXML
	MenuItem updateItem = new MenuItem();
	@FXML
	MenuItem viewItem = new MenuItem();
	@FXML
	MenuItem viewIndividualItem = new MenuItem();
	@FXML
	MenuItem searchPublisher = new MenuItem();
	@FXML
	MenuItem searchAuthor = new MenuItem();
	@FXML
	MenuItem searchISBN_Title = new MenuItem();
	@FXML
	MenuItem insertItem = new MenuItem();
	@FXML
	MenuItem science = new MenuItem();
	@FXML
	MenuItem art = new MenuItem();
	@FXML
	MenuItem history = new MenuItem();
	@FXML
	MenuItem religion = new MenuItem();
	@FXML
	MenuItem geography = new MenuItem();
	@FXML
	MenuItem addItem = new MenuItem();
	@FXML
	MenuItem modifyItem = new MenuItem();
	@FXML
	MenuItem placeOrderItem = new MenuItem();
	@FXML
	MenuItem confirmOrderItem = new MenuItem();
	@FXML
	MenuItem totalSalesReport = new MenuItem();
	@FXML
	MenuItem topFiveCustomerReport = new MenuItem();
	@FXML
	MenuItem topTenBooksReport = new MenuItem();
	@FXML
	TextField publisherText = new TextField();
	@FXML
	TextField authorText = new TextField();
	@FXML
	TextField ISBN_Title_Text = new TextField();
	@FXML
	Label shippingCart = new Label();
	@FXML
	ListView<String> list_Books = new ListView<String>();
	
    public void editInformation(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Edit.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
	}
	
	public void options(ActionEvent event) throws IOException {
		
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
