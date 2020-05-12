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
		Parent root = FXMLLoader.load(getClass().getResource("ManagerFXML.fxml"));
		Scene scence = new Scene(root);
		primaryStage.getIcons().add(new Image("DB.jpg"));
		primaryStage.setTitle("Order processing System");
		primaryStage.setScene(scence);
		primaryStage.show();
	}

	public static void main(String[] args)  {
 
		    launch(args);
	}
}
