import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerCustomers {

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
		stage.getIcons().add(new Image("DB.jpg"));
		stage.setScene(scene);
		stage.show();
	}

	public void profile(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.getIcons().add(new Image("DB.jpg"));
		stage.setScene(scene);
		stage.show();
	}

	public void search_forBook(ActionEvent event) throws IOException {
		boolean found = true;
		if (found) {
			Pane rootPane = new Pane();
			ObservableList<String> listChoices = FXCollections.observableArrayList("neveen");
			ListView<String> listView = new ListView<String>();
			listView.setItems(listChoices);
			rootPane.getChildren().add(listView);
			Stage newDialog = new Stage(StageStyle.UNIFIED);
			newDialog.getIcons().add(new Image("DB.jpg"));
			listView.setPrefWidth(800);
			listView.setPrefHeight(500);
			newDialog.setMinHeight(500);
			newDialog.setMinWidth(800);
			newDialog.initModality(Modality.APPLICATION_MODAL);
			newDialog.setTitle("Books");
			Scene newDialogScene = new Scene(rootPane);
			newDialog.setScene(newDialogScene);
			newDialog.show();
		} else {
			Alert a = new Alert(AlertType.NONE);
			// set alert type
			a.setAlertType(AlertType.ERROR);
			// set content text
			a.setContentText("No Specified Book");
			// show the dialog
			a.show();
		}
	}

	public void insert_Book(ActionEvent event) throws IOException {
		boolean found = true;
		if (found) {
			ObservableList<String> listChoices = FXCollections.observableArrayList("neveen");
			listChoices.add("merna");
			list_Books.setItems(listChoices);
		} else {
			Alert a = new Alert(AlertType.NONE);
			// set alert type
			a.setAlertType(AlertType.ERROR);
			// set content text
			a.setContentText("No Specified Book");
			// show the dialog
			a.show();
		}

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

	public void remove_booksFromCart(ActionEvent event) {
		list_Books.getItems().remove(list_Books.getSelectionModel().getSelectedItem());
	}
	
	public void view_items(ActionEvent event) {
		Pane rootPane = new Pane();
		ObservableList<String> listChoices = FXCollections.observableArrayList(list_Books.getItems());
		ListView<String> listView = new ListView<String>();
		listView.setItems(listChoices);
		rootPane.getChildren().add(listView);
		Stage newDialog = new Stage(StageStyle.UNIFIED);
		newDialog.getIcons().add(new Image("DB.jpg"));
		listView.setPrefWidth(800);
		listView.setPrefHeight(500);
		newDialog.setMinHeight(500);
		newDialog.setMinWidth(800);
		newDialog.initModality(Modality.APPLICATION_MODAL);
		newDialog.setTitle("My Books");
		Scene newDialogScene = new Scene(rootPane);
		newDialog.setScene(newDialogScene);
		newDialog.show();
	}
	public void view_IndividualAndTotalPriceofBooks(ActionEvent event) {
		Pane rootPane = new Pane();
		ObservableList<String> listChoices = null;
		ListView<String> listView = new ListView<String>();
		listView.setItems(listChoices);
		rootPane.getChildren().add(listView);
		Stage newDialog = new Stage(StageStyle.UNIFIED);
		newDialog.getIcons().add(new Image("DB.jpg"));
		listView.setPrefWidth(800);
		listView.setPrefHeight(500);
		newDialog.setMinHeight(500);
		newDialog.setMinWidth(800);
		newDialog.initModality(Modality.APPLICATION_MODAL);
		newDialog.setTitle("Individual And Total Price of Books");
		Scene newDialogScene = new Scene(rootPane);
		newDialog.setScene(newDialogScene);
		newDialog.show();
	}
}
