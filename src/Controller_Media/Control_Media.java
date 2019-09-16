package Controller_Media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Control_Media {
	
	/////////////////////////// �����Ȱ���� Media������ ������ �����ִ� �Լ� ////////////////////////////////////////
	
	//�α��� ȭ�� ������� �Լ�
	public MediaPlayer getLoginPageBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Credit_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
	//���� ȭ�� ������� �Լ�
	public MediaPlayer getGamePageBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Running_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
	//���� ũ���� ȭ�� ������� �Լ�
	public MediaPlayer getCreditPageBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Ending_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
	//���ʽ� Ÿ�� ȭ�� ������� �Լ�
	public MediaPlayer getFeverBgm() {
		Media media = new Media(getClass().getClassLoader().getResource("./Media/Fever_bgm.mp3").toString());
		MediaPlayer mediaplayer = new MediaPlayer(media);
		return mediaplayer;
	}
}
