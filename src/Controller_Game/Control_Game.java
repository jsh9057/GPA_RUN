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
	
	// 게임화면 음악 재생 함수
	public void getRunningBgm() {
		if (media != null)
			media.stop();
		media = mediaPlayer.getGamePageBgm();
		media.play();
	}
	
	//FeverTime 음악 재생 함수
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
	
	//Jelly를 먹었을때 점수 계산 함수
	public int setJellySocre() {
		model_Game.setScore(model_Game.getScore() + 1);
		return (int) model_Game.getScore();
	}

	//장애물에 부딪쳤을때 점수 계산 함수
	public int setFSocre() {
		model_Game.setScore(model_Game.getScore() - 2);
		return (int) model_Game.getScore();
	}

	
	///////////////////////////////////Referenced Control_Rank//////////////////////////////////////////
	
	// 1,2,3순위 이름, 아이디 리턴 함수
	public String[] select_nameRank() {
		return control_rank.select_nameRank();
	}
	// 1,2,3순위 점수 리턴 함수
	public String[] select_scoreRank() {
		return control_rank.select_scoreRank();
	}

	// 현재 점수 데이터 베이스로 업데이트 하는 함수
	public void update_scoreRank(int score) {
		control_rank.update_scoreRank(score);
	}
	
	// 로그아웃하는 함수
	public void Logout(){
		control_rank.Logout();
	}
	
	////////////////////////////////// Move Background in Scene /////////////////////////////////////////
	
	// 배경이미지 4개를 받아와 이벤트넣어주는 함수
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
