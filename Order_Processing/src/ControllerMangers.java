import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class ControllerMangers {

	@FXML
	Button manager = new Button();
	@FXML
	MenuItem edit = new MenuItem("Add new book");
	@FXML
	Button search = new Button();
	@FXML
	Menu add = new Menu("Add new book");
	@FXML
	MenuItem add1 = new MenuItem("Add new book");
	@FXML
	Button log_out = new Button();
	@FXML
	MenuButton manage = new MenuButton();
	@FXML
	MenuButton checkout = new MenuButton();
	MenuBar menuBar = new MenuBar();
	@FXML
	Menu menuFile1 = new Menu("ADD");
	

	
	public void options(ActionEvent event) throws IOException {
		
	}
	
    public void editInformation(ActionEvent event) throws IOException {
		
	}
	
	public void search_forBook(ActionEvent event) throws IOException {
		
	}
	
   public void add_Book(ActionEvent event) throws IOException {
	   System.out.println("add book");
	// Create the custom dialog.
	   Dialog<Pair<String, String>> dialog = new Dialog<>();
	   dialog.setTitle("Add new book");
	   dialog.setHeaderText("Please fill the following");

	   // Set the icon (must be included in the project).
	   dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

	   // Set the button types.
	   ButtonType loginButtonType = new ButtonType("Done", ButtonData.OK_DONE);
	   dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

	   // Create the username and password labels and fields.
	   GridPane grid = new GridPane();
	   grid.setHgap(10);
	   grid.setVgap(10);
	   grid.setPadding(new Insets(20, 150, 10, 10));

	   TextField ISBN = new TextField();
	   ISBN.setPromptText("ISBN");
	   ISBN.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					ISBN.setText(oldValue);
				}
			}
		});
	   TextField title = new TextField();
	   title.setPromptText("title");
	   TextField author = new TextField();
	   author.setPromptText("author");
	   TextField publisher = new TextField();
	   publisher.setPromptText("publisher");
	   TextField publication_year = new TextField();
	   publication_year.setPromptText("publication year");
	   publication_year.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					publication_year.setText(oldValue);
				}
			}
		});
	   TextField price = new TextField();
	   price.setPromptText("price");
	   price.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					price.setText(oldValue);
				}
			}
		});
//	   TextField category = new TextField();
	
	   final ComboBox<String> category = new ComboBox<String>();
	   category.getItems().addAll(
			   "Science", "Art", "Religion", "History" ,"Geography"
       );   

	   category.setValue("category");

	   grid.add(new Label("ISBN:"), 0, 0);
	   grid.add(ISBN, 1, 0);
	   grid.add(new Label("title:"), 0, 1);
	   grid.add(title, 1, 1);
	   grid.add(new Label("author:"), 0, 2);
	   grid.add(author, 1, 2);
	   grid.add(new Label("publisher:"), 0, 3);
	   grid.add(publisher, 1, 3);
	   grid.add(new Label("publication year:"), 0, 4);
	   grid.add(publication_year, 1, 4);
	   grid.add(new Label("price:"), 0, 5);
	   grid.add(price, 1, 5);
	   grid.add(new Label("category:"), 0, 6);
	   grid.add(category, 1, 6);

	   // Enable/Disable login button depending on whether a username was entered.
	   Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
	   loginButton.setDisable(true);

	   // Do some validation (using the Java 8 lambda syntax).
	   title.textProperty().addListener((observable, oldValue, newValue) -> {
	       loginButton.setDisable(newValue.trim().isEmpty());
	   });

	   dialog.getDialogPane().setContent(grid);

	   // Request focus on the username field by default.
	   Platform.runLater(() -> title.requestFocus());

	   // Convert the result to a username-password-pair when the login button is clicked.
	   dialog.setResultConverter(dialogButton -> {
	       if (dialogButton == loginButtonType) {
	           return new Pair<>(title.getText(), title.getText());
	       }
	       return null;
	   });

	   Optional<Pair<String, String>> result = dialog.showAndWait();

	   result.ifPresent(usernamePassword -> {
	       System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
	   });
	   
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
