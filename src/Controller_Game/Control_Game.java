package Controller_Game;

import Controller_Media.Control_Media;
import Controller_Rank.Control_Rank;
import Model.Model_Game;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Control_Game {

	Model_Game model_Game = new Model_Game();
	Control_Media mediaPlayer = new Control_Media();
	Control_Rank control_rank = new Control_Rank();
	private MediaPlayer media;

	/////////////////////////// Referenced Control_Media //////////////////////////////
	
	// ����ȭ�� ���� ��� �Լ�
	public void getRunningBgm() {
		if (media != null)
			media.stop();
		media = mediaPlayer.getGamePageBgm();
		media.play();
	}
	
	//FeverTime ���� ��� �Լ�
	public void getFeverBgm() {
		if (media != null)
			media.stop();
		media = mediaPlayer.getFeverBgm();
		media.play();
	}
	
	public void getCreditBgm() {
		if (media != null)
			media.stop();
		media = mediaPlayer.getCreditPageBgm();
		media.play();
	}
	////////////////////////////// Referenced Model_Game ///////////////////////////
	
	//Jelly�� �Ծ����� ���� ��� �Լ�
	public int setJellySocre() {
		model_Game.setScore(model_Game.getScore() + 1);
		return (int) model_Game.getScore();
	}

	//��ֹ��� �ε������� ���� ��� �Լ�
	public int setFSocre() {
		model_Game.setScore(model_Game.getScore() - 2);
		return (int) model_Game.getScore();
	}

	
	///////////////////////////////////Referenced Control_Rank//////////////////////////////////////////
	
	// 1,2,3���� �̸�, ���̵� ���� �Լ�
	public String[] select_nameRank() {
		return control_rank.select_nameRank();
	}
	// 1,2,3���� ���� ���� �Լ�
	public String[] select_scoreRank() {
		return control_rank.select_scoreRank();
	}

	// ���� ���� ������ ���̽��� ������Ʈ �ϴ� �Լ�
	public void update_scoreRank(int score) {
		control_rank.update_scoreRank(score);
	}
	
	// �α׾ƿ��ϴ� �Լ�
	public void Logout(){
		control_rank.Logout();
	}
	
	////////////////////////////////// Move Background in Scene /////////////////////////////////////////
	
	// ����̹��� 4���� �޾ƿ� �̺�Ʈ�־��ִ� �Լ�
	public void moveBackGround(ImageView Game_Background1_ImageView, ImageView Game_Background2_ImageView,
			ImageView Game_Background3_ImageView, ImageView Game_Background4_ImageView) {

		Timeline tml1 = new Timeline();
		tml1.setCycleCount(Timeline.INDEFINITE);
		Timeline tml2 = new Timeline();
		tml2.setCycleCount(Timeline.INDEFINITE);

		KeyFrame moveback1 = new KeyFrame(Duration.seconds(10),
				new KeyValue(Game_Background1_ImageView.translateXProperty(), -800),
				new KeyValue(Game_Background1_ImageView.translateYProperty(), 0));

		KeyFrame moveback2 = new KeyFrame(Duration.seconds(10),
				new KeyValue(Game_Background2_ImageView.translateXProperty(), -800),
				new KeyValue(Game_Background2_ImageView.translateYProperty(), 0));

		KeyFrame moveback3 = new KeyFrame(Duration.seconds(7),
				new KeyValue(Game_Background3_ImageView.translateXProperty(), -800),
				new KeyValue(Game_Background3_ImageView.translateYProperty(), 0));

		KeyFrame moveback4 = new KeyFrame(Duration.seconds(7),
				new KeyValue(Game_Background4_ImageView.translateXProperty(), -800),
				new KeyValue(Game_Background4_ImageView.translateYProperty(), 0));

		tml1.getKeyFrames().addAll(moveback1, moveback2);
		tml2.getKeyFrames().addAll(moveback3, moveback4);
		tml1.play();
		tml2.play();
	}

	

}
