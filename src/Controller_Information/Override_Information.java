package Controller_Information;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller_Media.Control_Media;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;

public class Override_Information implements Initializable{
	
@FXML
private Pane pane1;
@FXML
private Pane pane2;
@FXML
private Pane pane3;
@FXML
private Pane pane4;
@FXML
private Pane pane5;
@FXML
private Pane pane6;
@FXML
private Button Yes_btn1;
@FXML
private Button Yes_btn2;
@FXML
private Button Yes_btn3;
@FXML
private Button Yes_btn4;
@FXML
private Button Yes_btn5;
@FXML
private Button Gamestart_btn;
@FXML
private Pane Information_pane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		pane1.setVisible(true);
		pane2.setVisible(false);
		pane3.setVisible(false);
		pane4.setVisible(false);
		pane5.setVisible(false);
		pane6.setVisible(false);
		Control_Media media = new Control_Media();
		MediaPlayer mediaPlayer = media.getLoginPageBgm();
		mediaPlayer.play();
		Yes_btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pane1.setVisible(false);
				pane2.setVisible(true);

			}

		});
		Yes_btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pane2.setVisible(false);
				pane3.setVisible(true);

			}

		});
		Yes_btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pane3.setVisible(false);
				pane4.setVisible(true);

			}

		});
		Yes_btn4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pane4.setVisible(false);
				pane5.setVisible(true);

			}

		});
		Yes_btn5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pane5.setVisible(false);
				pane6.setVisible(true);

			}

		});
		
		Gamestart_btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mediaPlayer.stop();
				try {
					
					Parent Game = FXMLLoader.load(getClass().getClassLoader().getResource("_View/Game_Page.fxml"));
					Information_pane = (Pane)Information_pane.getScene().getRoot();
					Information_pane.getChildren().clear();
					Information_pane.getChildren().add(Game);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		
	}

}
