package Controller_Ending;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Override_Ending implements Initializable {
	@FXML
	private Pane Endingpane;
	@FXML
	private Pane Endingpane1;
	@FXML
	private Pane EndingPane2;
	@FXML
	private ImageView Background;
	@FXML
	private ImageView Character_p;
	@FXML
	private ImageView A_plus;
	@FXML
	private Button Yes_btn;
	@FXML
	private Button Yes_btn2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		Control_Ending Control = new Control_Ending();
		Control.Aplus_move(A_plus);
		
		
		Yes_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			
				Endingpane1.setVisible(false);
				EndingPane2.setVisible(true);
				
			}

		});
		
		Yes_btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					Parent EndingCredit = FXMLLoader
							.load(getClass().getClassLoader().getResource("_View/Ending_Credit_Page.fxml"));
					Endingpane = (Pane) Endingpane.getScene().getRoot();
					Endingpane.getChildren().clear();
					Endingpane.getChildren().add(EndingCredit);
				} catch (IOException e) {
					e.printStackTrace();
				}

				
			}
		});
	}
}