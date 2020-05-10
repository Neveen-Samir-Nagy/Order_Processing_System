import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("Sign_IN_OUT.fxml"));
		Scene scence = new Scene(root);
		primaryStage.setTitle("Order processing System");
		primaryStage.setScene(scence);
		primaryStage.show();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(  
				    "jdbc:oracle:thin:@localhost:1521:xe","system","password");
			Statement stmt=con.createStatement();  
		    launch(args);
	}
}
