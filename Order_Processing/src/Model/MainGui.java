package Model;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainGui extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Reports r = new Reports();
		r.total_sales();
		Parent root = FXMLLoader.load(getClass().getResource("../View/Sign_IN.fxml"));
		Scene scence = new Scene(root);
		primaryStage.getIcons().add(new Image("Book.jpeg"));
		primaryStage.setTitle("Order processing System");
		primaryStage.setScene(scence);
		primaryStage.show();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		    launch(args);
	}
}
