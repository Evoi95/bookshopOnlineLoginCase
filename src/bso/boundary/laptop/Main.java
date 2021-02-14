package bso.boundary.laptop;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Logger; 
  
import bso.database.CreateDefaultDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static final Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
	
	@Override
	public void start(Stage primaryStage) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Benvenuto nella homePage");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
	        logger.warning("Error in launch HomePage :\n"+e); 	

		}

	}

	public static void main(String[] args) {
		
		try {
			CreateDefaultDB.createDefaultDB();
			logger.info("START PROGRAM");
			
		} catch (ClassNotFoundException | FileNotFoundException | SQLException e) {
			 
	        logger.warning("Error in main :\n"+e); 	
		} 

		Application.launch(args);

	}
}
