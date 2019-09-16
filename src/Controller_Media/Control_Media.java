package Controller_Media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Control_Media {
	
	/////////////////////////// 지정된경로의 Media파일을 가져와 보내주는 함수 ////////////////////////////////////////
	
	//로그인 화면 배경음악 함수
	public MediaPlayer getLoginPageBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Credit_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
	//게임 화면 배경음악 함수
	public MediaPlayer getGamePageBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Running_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
	//엔딩 크레딧 화면 배경음악 함수
	public MediaPlayer getCreditPageBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Ending_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
	//보너스 타임 화면 배경음악 함수
	public MediaPlayer getFeverBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Fever_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
}
