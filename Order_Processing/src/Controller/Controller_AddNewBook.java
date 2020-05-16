package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;

import Model.Book;
import Model.SingletonClasses;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_AddNewBook {
	@FXML
	Button add = new Button();
	@FXML
	Label ISBN = new Label();
	@FXML
	Label title = new Label();
	@FXML
	Label author = new Label();
	@FXML
	Label publisher = new Label();
	@FXML
	Label year = new Label();
	@FXML
	Label price = new Label();
	@FXML
	Label category = new Label();
	@FXML
	Label newBook = new Label();
	@FXML
	TextField ISBNText = new TextField();
	@FXML
	TextField titleText = new TextField();
	@FXML
	TextField publisherText = new TextField();
	@FXML
	TextField yearText = new TextField();
	@FXML
	TextField priceText = new TextField();
	@FXML
	TextField categoryText = new TextField();
	@FXML
	TextField authorText = new TextField();
	@FXML
	TextField publisherAddressText = new TextField();
	@FXML
	TextField publisherPhoneText = new TextField();

	SingletonClasses s2 = SingletonClasses.getoneclass();

	public void done(ActionEvent event) throws IOException, ParseException {
		if (s2.get_book().equals("add")) {
			Book b = new Book(ISBNText.getText(), titleText.getText(), authorText.getText(), publisherText.getText(),
					yearText.getText(), Integer.parseInt(priceText.getText()), categoryText.getText(), 0, 0,
					publisherAddressText.getText(), publisherPhoneText.getText());
			s2.manager.add_publisher(b.get_publisher(), b.get_publisherAddress(), b.get_publisherPhone());
			s2.manager.add_NewBook(b);
			s2.manager.add_author(b.get_ISBN(), b.get_author());
		} else if (s2.get_book().equals("modify")) {
			Book b_modify = new Book(null,null,null,null,null,0,null,0,0,null,null);
			if (ISBNText.getText() != "Null") {
				
			}
			if (titleText.getText() != "Null") {

			}
			if (categoryText.getText() != "Null") {

			}
			if (publisherText.getText() != "Null") {

			}
			if (yearText.getText() != "Null") {

			}
			if (priceText.getText() != "Null") {

			}
			if (authorText.getText() != "Null") {

			}

			// s2.manager.modify_ExistingBook(s2.get_column_book(), s2.get_value_book(),
			// column, value);
		}
		Stage stage = (Stage) add.getScene().getWindow();
		stage.close();
	}
}
