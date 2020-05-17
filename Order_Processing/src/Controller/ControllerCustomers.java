package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import Model.Book;
import Model.SingletonClasses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	Menu checkOut = new Menu();
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
	MenuItem creditCard_Item = new MenuItem();
	@FXML
	MenuItem date_Item = new MenuItem();
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
	TextField creditCardText = new TextField();
	@FXML
	TextField dateText = new TextField();
	@FXML
	Label shippingCart = new Label();
	@FXML
	ListView<String> list_Books = new ListView<String>();

	SingletonClasses s2 = SingletonClasses.getoneclass();

	public void editInformation(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../View/Edit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.getIcons().add(new Image("Book.jpeg"));
		stage.setScene(scene);
		stage.show();
	}

	public void profile(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../View/Profile.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.getIcons().add(new Image("Book.jpeg"));
		stage.setScene(scene);
		stage.show();
	}

	public void search_forBook(ActionEvent event) throws IOException, SQLException {
		ResultSet result_search = null;
		Book b = new Book(null, null, null, null, null, 0, null, 0, 0, null, null);
		if (event.getSource() instanceof MenuItem) {
			b.set_category(((MenuItem) event.getSource()).getText());
			result_search = s2.customer.search_ForBooks(b);
		} else if (event.getSource() instanceof TextField) {
			if (((TextField) event.getSource()).getId().contains("publisher")) {
				b.set_publisher(((TextField) event.getSource()).getText());
				result_search = s2.customer.search_ForBooks(b);
			} else if (((TextField) event.getSource()).getId().contains("author")) {
				String[] arrOfStr = ((TextField) event.getSource()).getText().split(" ");
				for (String a : arrOfStr) {
					b.set_author(a);
					result_search = s2.customer.search_ForBooks(b);
				}
			} else if (((TextField) event.getSource()).getId().contains("ISBN_Title")) {
				String[] arrOfStr = ((TextField) event.getSource()).getText().split(" ");
				b.set_ISBN(arrOfStr[0]);
				b.set_title(arrOfStr[1]);
				result_search = s2.customer.search_ForBooks(b);
			}

		}
		if (result_search.next()) {
			Pane rootPane = new Pane();
			ObservableList<String> choices = FXCollections.observableArrayList("Book1");
			int i=2;
			while(result_search.next()) {
				choices.add("Book"+(i));
				i++;
			}
			ListView<String> listView = new ListView<String>();
			listView.setItems(choices);
			rootPane.getChildren().add(listView);
			Stage newDialog = new Stage(StageStyle.DECORATED);
			newDialog.getIcons().add(new Image("Book.jpeg"));
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

	public void insert_Book(ActionEvent event) throws IOException, SQLException {
		ResultSet result_search = null;
		Book b = new Book(null, null, null, null, null, 0, null, 0, 0, null, null);
		if (event.getSource() instanceof MenuItem) {
			b.set_category(((MenuItem) event.getSource()).getText());
			result_search = s2.customer.search_ForBooks(b);
		} else if (event.getSource() instanceof TextField) {
			if (((TextField) event.getSource()).getId().contains("publisher")) {
				b.set_publisher(((TextField) event.getSource()).getText());
			} else if (((TextField) event.getSource()).getId().contains("author")) {
				b.set_author(((TextField) event.getSource()).getText());
			} else if (((TextField) event.getSource()).getId().contains("ISBN_Title")) {
				String[] arrOfStr = ((TextField) event.getSource()).getText().split(" ");
				b.set_ISBN(arrOfStr[0]);
				b.set_title(arrOfStr[1]);
			}
			result_search = s2.customer.search_ForBooks(b);
		}
		if (result_search.next()) {
			ObservableList<String> choices = FXCollections.observableArrayList("Book1");
			int i=2;
			while(result_search.next()) {
				choices.add("Book"+(i));
				i++;
			}
			list_Books.setItems(choices);
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
		Parent loader = FXMLLoader.load(getClass().getResource("../View/Sign_IN.fxml"));
		Scene scene = new Scene(loader);
		Stage app = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		app.setScene(scene);
		app.show();

	}

	public void checkOut(ActionEvent event) throws IOException {
		// remove book from table that are in shipping cart list_books
		if (creditCardText.getText().equals("") || dateText.getText().equals("")) {
			Alert a = new Alert(AlertType.NONE);
			// set alert type
			a.setAlertType(AlertType.ERROR);
			// set content text
			a.setContentText("Please Enter all required Information");
			// show the dialog
			a.show();
		} else {
			/*
			 * ObservableList<ResultSet> listChoices = list_Books.getItems(); for (int i =
			 * 0; i < listChoices.size(); i++) { s2.customer.checkOut(listChoices.get(i)); }
			 * for (int i = 0; i < listChoices.size(); i++) {
			 * list_Books.getItems().remove(i); }
			 */
		}
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
		Stage newDialog = new Stage(StageStyle.DECORATED);
		newDialog.getIcons().add(new Image("Book.jpeg"));
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
		ResultSet view = s2.customer.view_Individual_TotalPrices();
		Pane rootPane = new Pane();
		ObservableList<ResultSet> listChoices = FXCollections.observableArrayList(view);
		ListView<ResultSet> listView = new ListView<ResultSet>();
		listView.setItems(listChoices);
		rootPane.getChildren().add(listView);
		Stage newDialog = new Stage(StageStyle.DECORATED);
		newDialog.getIcons().add(new Image("Book.jpeg"));
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
