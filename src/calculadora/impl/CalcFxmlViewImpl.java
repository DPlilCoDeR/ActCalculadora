package calculadora.impl;

import calculadora.CalcContract.CalcPresenter;
import calculadora.CalcContract.CalcView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CalcFxmlViewImpl implements Initializable, CalcView {

	private CalcPresenter presenter;
	
	public CalcFxmlViewImpl(Stage stage) {		
		initUI(stage);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	// BEANS

	@Override
	public void setPresenter(CalcPresenter presenter) {		
		this.presenter = presenter;
	}
	
	// UI
	
	private void initUI(Stage stage) {
		
		FXMLLoader loader = new FXMLLoader();		
		loader.setController(this);		
		loader.setLocation(getClass().getResource("calculadora/impl/FXMLDocument.fxml"));
		
		try {
		Parent root = loader.load();			
	        Scene scene = new Scene(root);	      
	     	        
	        stage.setScene(scene);
	        stage.setTitle("FXML View version");
	        stage.show();
			
		} catch (IOException e) {
			throw new RuntimeException("loading FXMLDocument.xml", e);
		}
	}

	// VIEW ACTIONS

	@Override
	public void setInput(String input) {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public void setOutput(String output) {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public String getInput() {
		throw new RuntimeException("no implementat!");
	}

	@Override
	public String getOutput() {
		throw new RuntimeException("no implementat!");
	}

}
