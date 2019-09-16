package Controller_Ending_Credit;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Override_Ending_Credit implements Initializable{

	@FXML 
	private ImageView Ending_Credit;
	@FXML
	private ImageView Run_Maincharacter; 
	@FXML
	private Pane Ending_Pane;
	Controller_Ending_Credit ending_credit_contoller = new Controller_Ending_Credit();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ending_credit_contoller.move_endingcredit(Ending_Credit);
		ending_credit_contoller.run_endingcredit(Run_Maincharacter).play();
		
	
		
	}

}
