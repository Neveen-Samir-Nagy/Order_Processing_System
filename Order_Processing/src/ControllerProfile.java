import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerProfile {
	@FXML
	Label profile = new Label();
	@FXML
	Label usernameLabel = new Label();
	@FXML
	Label passwordLabel = new Label();
	@FXML
	Label typeLabel = new Label();
	@FXML
	Label emailLabel = new Label();
	@FXML
	Label shippingLabel = new Label();
	@FXML
	Label phoneLabel = new Label();
	@FXML
	Label firstnameLabel = new Label();
	@FXML
	Label lastnameLabel = new Label();
	@FXML
	Label usernameText = new Label();
	@FXML
	Label passwordText = new Label();
	@FXML
	Label typeText = new Label();
	@FXML
	Label firstnameText = new Label();
	@FXML
	Label lastnameText = new Label();
	@FXML
	Label phoneText = new Label();
	@FXML
	Label emailText = new Label();
	@FXML
	Label shippingText = new Label();
	@FXML
	ImageView back = new ImageView();
	
	public void done(MouseEvent event) throws IOException {
		Stage stage = (Stage) back.getScene().getWindow();
	    stage.close();
	}
}
