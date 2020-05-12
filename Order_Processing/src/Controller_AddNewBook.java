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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	ObservableList<String> categoryOptions = 
    FXCollections.observableArrayList(
    		"Science", "Art", "Religion", "History" , "Geography"
    );
	final ComboBox comboBox = new ComboBox(categoryOptions);
	SingletonClasses s2 = SingletonClasses.getoneclass();
	Manager m = new Manager();
	
	public void done(ActionEvent event) throws IOException {
	  if(chek_digits(ISBNText.getText()) && chek_digits(priceText.getText())) {
		int isbn = Integer.parseInt(ISBNText.getText()), p=Integer.parseInt(priceText.getText());
		String t = titleText.getText(), auth =  authorText.getText(), pub =  publisherText.getText(), y = yearText.getText(),
				cat= categoryText.getText();
		
		Book b = new Book(isbn, t, auth, pub, y, p, cat);
		m.add_NewBook(b);
		Stage stage = (Stage) add.getScene().getWindow();
	    stage.close();
	  }
	  else {
		  Alert a = new Alert(AlertType.ERROR);
		  a.setContentText("ISBN and Price must be a number"); 
          a.show(); 
	  }
	}
	public boolean chek_digits(String s) {
		String pattern = "\\w+";
	      Pattern r = Pattern.compile(pattern);
	      Matcher m = r.matcher(s);
	      return !m.find();
	}
}
