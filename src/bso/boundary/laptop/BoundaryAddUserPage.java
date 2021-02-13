package bso.boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class BoundaryAddUserPage implements Initializable{
	@FXML
	private  Pane pane;
	@FXML
	private Label header;
	@FXML
	private GridPane grid;
	@FXML
	private Label nomeL;
	@FXML
	private Label cognomeL;
	@FXML
	private Label emailL;
	@FXML
	private Label pwdL;
	@FXML
	private Label descL;
	@FXML
	private Label dataL;
	@FXML
	private Label ruoloL;
	@FXML
	private TextField nomeTF;
	@FXML
	private TextField cognomeTF;
	@FXML
	private TextField emailTF;
	@FXML
	private PasswordField pwdTF;
	@FXML
	private TextArea descTA;
	@FXML
	private DatePicker dataN;
	@FXML
	private TextField ruoloTF;
	@FXML
	private Button insB;
	@FXML
	private Button annB;
	
	@FXML
	private void inserisciUtente() {

	
		
	}
	@FXML
	private void torna() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) annB.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
		stage.setTitle("Benvenuto nella schermata del login");
		Scene scene = new Scene(root);
		stage.setScene(scene);


	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
