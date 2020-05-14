import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.LinkedList;
import java.util.Queue;

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

	
	SingletonClasses s2 = SingletonClasses.getoneclass();
	
	public void done(ActionEvent event) throws IOException {
		if(s2.get_book().equals("add")) {
			s2.manager.add_NewBook(ISBNText.getText(), titleText.getText(), publisherText.getText(),
					authorText.getText(), yearText.getText(), priceText.getText());
		}else if(s2.get_book().equals("modify")) {
			Queue<String> column = new LinkedList<String>();
			Queue<String> value = new LinkedList<String>();
			if(ISBNText.getText() != "Null") {
				column.add("ISBN");
				value.add(ISBNText.getText());
			}
			if(titleText.getText() != "Null") {
				column.add("Tilte");
				value.add(titleText.getText());
			}
			if(categoryText.getText() != "Null") {
				column.add("Category");
				value.add(categoryText.getText());
			}
			if(publisherText.getText() != "Null") {
				column.add("Publisher_Name");
				value.add(publisherText.getText());
			}
			if(yearText.getText() != "Null") {
				column.add("Publication_Year");
				value.add(yearText.getText());
			}
			if(priceText.getText() != "Null") {
				column.add("Selling_Price");
				value.add(priceText.getText());
			}
			if(authorText.getText() != "Null") {
				column.add("Author");
				value.add(authorText.getText());
			}
			s2.manager.modify_ExistingBook(s2.get_column_book(), s2.get_value_book(), column, value);
		}
		Stage stage = (Stage) add.getScene().getWindow();
	    stage.close();

	}
}
