package calculadora.impl;

import calculadora.CalcContract.CalcPresenter;
import calculadora.CalcContract.CalcView;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;


public class CalcFxmlApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		
		CalcView view = new CalcFxmlViewImpl(stage);		
		CalcPresenter presenter = new CalcPresenterImpl();
		
		presenter.setView(view);
		view.setPresenter(presenter);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
