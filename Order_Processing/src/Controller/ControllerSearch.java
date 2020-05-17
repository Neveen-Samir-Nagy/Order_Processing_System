package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Book;
import Model.SingletonClasses;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class ControllerSearch implements Initializable{

	@FXML
	TableView<Book> table = new TableView<Book>();
	@FXML
	Button insert = new Button();
	SingletonClasses s2 = SingletonClasses.getoneclass();
	
	@SuppressWarnings("rawtypes")
	public void insert_toCart(ActionEvent event) {
		ObservableList selectedItems = table.getSelectionModel().getSelectedItems();
		s2.list_insert.add((Book)selectedItems);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			while(s2.list_search.next()) {
				
				Book b = new Book(s2.list_search.getString(1), s2.list_search.getString(2), s2.list_search.getString(3),
						 s2.list_search.getString(5),  s2.list_search.getString(6), s2.list_search.getInt(7), s2.list_search.getString(4),
						 s2.list_search.getInt(8), s2.list_search.getInt(9),null,null);
			         table.getItems().add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
