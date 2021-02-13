package bso.boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import bso.controller.SingeltonSystemState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryModifRivista implements Initializable{
		@FXML
		private Pane pane;
		@FXML
		private Label header;
		@FXML
		private GridPane grid;
		@FXML
		private Label labelT;
		@FXML
		private Label labelTipo;
		@FXML
		private Label labelA;
		@FXML
		private Label labelLingua;
		@FXML
		private Label labelE;
		@FXML
		private Label labelDesc;
		@FXML
		private Label labelData;
		@FXML
		private Label labelDisp;
		@FXML
		private Label labelP;
		@FXML
		private Label labelCopie;
		@FXML
		private TextField titoloTF;
		@FXML
		private TextField tipologiaTF;
		@FXML
		private TextField autoreTF;
		@FXML
		private TextField linguaTF;
		@FXML
		private TextField editoreTF;
		@FXML
		private TextArea descTA;
		@FXML
		private DatePicker datePick;
		@FXML
		private CheckBox dispCheck;
		@FXML
		private TextField prezzoTF;
		@FXML
		private TextField copieTF;
		@FXML
		private Button buttonAdd;
		@FXML
		private Button buttonI;
		
		@FXML
		private Label titoloV;
		@FXML
		private Label tipologiaV;
		@FXML
		private Label autoreV;
		@FXML
		private Label linguaV;
		@FXML
		private Label editoreV;
		@FXML
		private Label descV;
		@FXML
		private Label dataV;
		@FXML
		private Label dispV;
		@FXML
		private Label prezzoV;
		@FXML
		private Label copieV;

		private SingeltonSystemState vis= SingeltonSystemState.getIstance();

		
		
		
		
		@FXML
		private void aggiungi() throws SQLException
		{
			String t=titoloTF.getText();
			String tipologia=tipologiaTF.getText();// np=Integer.parseInt(numeroPagineT.getText());
			String autore=autoreTF.getText();
			String l=linguaTF.getText();
			String e=editoreTF.getText();
			String desc=descTA.getText();
			LocalDate d=datePick.getValue();
			boolean disp=dispCheck.isPressed();

			
			int dispo;
			
			if(disp)
			{
				dispo=1;
				
			}
			else {
				dispo=0;
			}
			float prezzo=Float.parseFloat(prezzoTF.getText());
			int copie=Integer.parseInt(copieTF.getText());			
			
		}
		
		@FXML 
		private void torna() throws IOException
		{
			Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("rivistaPage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		
		}
		@Override
		public void initialize(URL location, ResourceBundle resources) {
		
		}
			
}
