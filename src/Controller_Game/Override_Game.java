package Controller_Game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.ArrayList_Return;
import Model.Model_Character;
import Model.Model_Image;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Override_Game implements Initializable {

	// Game Page에 쓰이는 컨트롤
	@FXML
	private Pane Game_pane;
	@FXML
	private ImageView Game_Maincharacter_ImageView;
	@FXML
	private ImageView Game_Background1_ImageView;
	@FXML
	private ImageView Game_Background2_ImageView;
	@FXML
	private ImageView Game_Background3_ImageView;
	@FXML
	private ImageView Game_Background4_ImageView;
	@FXML
	private ImageView Game_UI_ImageView;
	@FXML
	private ImageView Game_GageBar_ImageView;
	@FXML
	private ImageView Pause_Image;
	@FXML
	private Pane Game_Ranking_Pane;
	@FXML
	private Button Game_Ranking_btn;
	@FXML
	private Label Game_Score_Label;
	@FXML
	private Label Rank_name1_Label;
	@FXML
	private Label Rank_name2_Label;
	@FXML
	private Label Rank_name3_Label;
	@FXML
	private Label Rank_Myscore_Label;
	@FXML
	private Label Rank_score1_Label;
	@FXML
	private Label Rank_score2_Label;
	@FXML
	private Label Rank_score3_Label;

	Control_Game control = new Control_Game();
	Model_Image model_Image = new Model_Image();
	Model_Character model_character = new Model_Character();
	Control_setImage setImage = new Control_setImage();
	ArrayList_Return rt = new ArrayList_Return();
	boolean fever = false;

	splite_Image splite_image;
	Animation animation;
	Animation Main_Character_animation;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Pause_Image.setVisible(false);
		Game_Ranking_Pane.setVisible(false);

		Game_Ranking_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					control.getCreditBgm();
					Parent Ending = FXMLLoader
							.load(getClass().getClassLoader().getResource("_View/Ending_Page.fxml"));
					Game_pane = (Pane) Game_pane.getScene().getRoot();
					Game_pane.getChildren().clear();
					Game_pane.getChildren().add(Ending);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		// 메인케릭터 이동
		splite_image = new splite_Image(Game_Maincharacter_ImageView, Duration.millis(100), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		animation = splite_image;
		splite_image.seting_run_sprite(Game_Maincharacter_ImageView, animation, splite_image).play();

		// Map setting
		rt = setImage.setImageView(model_Image.getJelly(), model_Image.getF_High(), model_Image.getF_under());
		setJellyInMap();
		setF_HighInMap();
		setF_underInMap();
		setLastInMap();

		// Bgm setting
		control.getRunningBgm();

		// BackGround Event
		control.moveBackGround(Game_Background1_ImageView, Game_Background2_ImageView, Game_Background3_ImageView,
				Game_Background4_ImageView);

		// Character Event
		Game_Maincharacter_ImageView.setFocusTraversable(true);
		Game_Maincharacter_ImageView.toFront();
		Game_Score_Label.toFront();
		Game_GageBar_ImageView.toFront();
		Game_UI_ImageView.toFront();
		TranslateTransition translation = new TranslateTransition(Duration.millis(200), Game_Maincharacter_ImageView);

		
		Game_Maincharacter_ImageView.setOnKeyPressed(event -> {
			switch (event.getCode()) {
			case UP:

				if (fever != true) {
					translation.interpolatorProperty().set(Interpolator.SPLINE(.0, .0, .8, .8));
					translation.setByY(-100);
					translation.setAutoReverse(true);
					translation.setCycleCount(2);
					translation.play();
					translation.durationProperty();
				}
				break;
			case DOWN:
				if (fever != true) 
					splite_image.seting_slide_sprite(Game_Maincharacter_ImageView, animation, splite_image);
					
				
				break;
			case Z:
			
				break;
			case X:
				break;
			
			}

		});


		Game_Maincharacter_ImageView.setOnKeyReleased(eventt -> {
			switch (eventt.getCode()) {
			case DOWN:
				if (fever != true) {
					
					splite_image.seting_run_sprite(Game_Maincharacter_ImageView, animation, splite_image);
					
				}
				break;
			}

		});
	}

	Timeline timeLine_jelly;
	Timeline timeLine_Last;
	Timeline timeLine_F_High;
	Timeline timeLine_F_under;

	public void setJellyInMap() {
		int dx = -1;
		int i = 0;
		while (i < rt.ImageJellyList.size()) {
			// Image setting
			ImageView image_jelly = rt.ImageJellyList.get(i);

			// Animation 생성
			timeLine_jelly = new Timeline();
			timeLine_jelly.setCycleCount(Animation.INDEFINITE);

			KeyFrame move_jelly = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					double imageMinX = image_jelly.getBoundsInParent().getMinX();
					double imageMaxY = image_jelly.getBoundsInParent().getMaxY();
					if (imageMinX > Game_Maincharacter_ImageView.getBoundsInParent().getMinX()
							&& imageMinX < Game_Maincharacter_ImageView.getBoundsInParent().getMaxX()
							&& imageMaxY < Game_Maincharacter_ImageView.getBoundsInParent().getMaxY()
							&& imageMaxY > Game_Maincharacter_ImageView.getBoundsInParent().getMinY()) {
						image_jelly.setImage(null);
						image_jelly.setLayoutX(0);
						Game_GageBar_ImageView.setFitWidth(Game_GageBar_ImageView.getFitWidth() + 3);
						Game_Score_Label.setText("" + control.setJellySocre());
						if (fever == true) {
							Game_GageBar_ImageView.setFitWidth(Game_GageBar_ImageView.getFitWidth() - 6);

						}

					}
					if (Game_GageBar_ImageView.getFitWidth() > 300) {
						
						splite_image.seting_fever_sprite(Game_Maincharacter_ImageView, animation, splite_image);
						fever = true;
					}
					if (Game_GageBar_ImageView.getFitWidth() < 50) {
						fever = false;
						animation.stop();
						splite_image.seting_run_sprite(Game_Maincharacter_ImageView, animation, splite_image);
						animation.play();
					}
					image_jelly.setTranslateX(image_jelly.getTranslateX() + dx);
				}
			});
			timeLine_jelly.getKeyFrames().add(move_jelly);
			timeLine_jelly.play();
			Game_pane.getChildren().add(image_jelly);
			i++;

		}
	}

	public void setLastInMap() {
		int dx = -1;
		int i = 0;
		while (i < rt.ImageLastList.size()) {
			// Image setting
			ImageView image_jelly = rt.ImageLastList.get(i);

			// Animation 생성
			timeLine_Last = new Timeline();
			timeLine_Last.setCycleCount(Animation.INDEFINITE);

			KeyFrame move_jelly = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					double imageMinX = image_jelly.getBoundsInParent().getMinX();
					double imageMaxY = image_jelly.getBoundsInParent().getMaxY();
					if (imageMinX > Game_Maincharacter_ImageView.getBoundsInParent().getMinX()
							&& imageMinX < Game_Maincharacter_ImageView.getBoundsInParent().getMaxX()
							&& imageMaxY < Game_Maincharacter_ImageView.getBoundsInParent().getMaxY()
							&& imageMaxY > Game_Maincharacter_ImageView.getBoundsInParent().getMinY()) {

						image_jelly.setImage(null);
						image_jelly.setLayoutX(0);
						Pause_Image.toFront();
						Pause_Image.setVisible(true);
						Game_Ranking_Pane.setVisible(true);
						Game_Ranking_Pane.toFront();
						// score
						control.update_scoreRank(Integer.parseInt(Game_Score_Label.getText()));
						String[] name = control.select_nameRank();
						String[] score = control.select_scoreRank();
						control.Logout();
						Rank_name1_Label.setText(name[0]);
						Rank_name2_Label.setText(name[1]);
						Rank_name3_Label.setText(name[2]);
						Rank_score1_Label.setText(score[0]);
						Rank_score2_Label.setText(score[1]);
						Rank_score3_Label.setText(score[2]);
						Rank_Myscore_Label.setText(Game_Score_Label.getText());
					}
					image_jelly.setTranslateX(image_jelly.getTranslateX() + dx);
				}
			});
			timeLine_Last.getKeyFrames().add(move_jelly);
			timeLine_Last.play();
			Game_pane.getChildren().add(image_jelly);
			i++;

		}
	}

	public void setF_HighInMap() {
		int dx = -1;
		int i = 0;
		while (i < rt.ImageF_HighList.size()) {
			// Image setting
			ImageView image_F_High = rt.ImageF_HighList.get(i);

			timeLine_F_High = new Timeline();
			timeLine_F_High.setCycleCount(Animation.INDEFINITE);

			KeyFrame move_F_High = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					double imageMinX = image_F_High.getBoundsInParent().getMinX();
					double imageMaxY = image_F_High.getBoundsInParent().getMaxY();
					if (imageMinX > Game_Maincharacter_ImageView.getBoundsInParent().getMinX()
							&& imageMinX < Game_Maincharacter_ImageView.getBoundsInParent().getMaxX()
							&& imageMaxY < Game_Maincharacter_ImageView.getBoundsInParent().getMaxY()
							&& imageMaxY > Game_Maincharacter_ImageView.getBoundsInParent().getMinY()) {
						image_F_High.setImage(null);
						image_F_High.setLayoutX(0);
						if (fever == false) {
							Game_Score_Label.setText("" + control.setFSocre());
							Game_GageBar_ImageView.setFitWidth(Game_GageBar_ImageView.getFitWidth() - 5);
						}
					}
					image_F_High.setTranslateX(image_F_High.getTranslateX() + dx);
				}
			});
			timeLine_F_High.getKeyFrames().add(move_F_High);
			timeLine_F_High.play();
			Game_pane.getChildren().add(image_F_High);
			i++;

		}
	}

	public void setF_underInMap() {
		int dx = -1;
		int i = 0;
		while (i < rt.ImageF_underList.size()) {
			// Image setting
			ImageView image_F_under = rt.ImageF_underList.get(i);

			timeLine_F_under = new Timeline();
			timeLine_F_under.setCycleCount(Animation.INDEFINITE);

			KeyFrame move_F_under = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					double imageMinX = image_F_under.getBoundsInParent().getMinX();
					double imageMaxY = image_F_under.getBoundsInParent().getMaxY();
					if (imageMinX > Game_Maincharacter_ImageView.getBoundsInParent().getMinX()
							&& imageMinX < Game_Maincharacter_ImageView.getBoundsInParent().getMaxX()
							&& imageMaxY < Game_Maincharacter_ImageView.getBoundsInParent().getMaxY()
							&& imageMaxY > Game_Maincharacter_ImageView.getBoundsInParent().getMinY()) {
						image_F_under.setImage(null);
						image_F_under.setLayoutX(0);
						if (fever == false) {
							Game_Score_Label.setText("" + control.setFSocre());
							Game_GageBar_ImageView.setFitWidth(Game_GageBar_ImageView.getFitWidth() - 5);
						}
						image_F_under.setTranslateX(image_F_under.getTranslateX() + dx);
					}
				}
			});
			timeLine_F_under.getKeyFrames().add(move_F_under);
			timeLine_F_under.play();
			Game_pane.getChildren().add(image_F_under);
			i++;

		}
	}

	
}
