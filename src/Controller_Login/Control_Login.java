package Controller_Login;

import Controller_Media.Control_Media;
import DataBase.Control_DataBase;
import javafx.scene.media.MediaPlayer;

public class Control_Login {
	Control_DataBase dataBase = new Control_DataBase();
	Control_Media media = new Control_Media();
	MediaPlayer mediaplay;
	
	//////////////////Reference Controller_Media ////////////////
	
	//������ ��������ִ� �Լ�
	public void play_LoginPage_MediaPlayer(){
		mediaplay = media.getLoginPageBgm();
		mediaplay.play();
	}
	
	//������ ���������ִ� �Լ�
	public void stop_LoginPage_MediaPlayer() {
		mediaplay.stop();
	}
	
	/////////////////////Reference Database///////////////////////
	
	//���� �α��λ��¸� �����ͺ��̽��� ������Ʈ�ϴ� �Լ�
	public void Update_login(String Name){
		dataBase.Update_LoginSQL(Name);
	}
	
	//������̵��� ��й�ȣ�� �´��� Ȯ���ϴ� �Լ�
	public boolean select_PW(String _ID, String _PW) {
		String PW = dataBase.Select_Login_SQL(_ID);
		
		if(PW != null)
			return PW.equals(_PW);
		
		else
			return false;
		//return (PW.equals(_PW)) ? true : false;
	}

	//���� ID�� �ߺ��� �Ǵ��� Ȯ���ϴ� �Լ�
	public boolean select_ID(String _ID) {
		String ID = dataBase.Select_Regist_SQL(_ID);
		return (ID == null) ? true : false;
	}

	//ȸ�������� �Է��� ������ Database�� �־��ִ� �Լ�
	public void insert_UserInfo(String[] UserInfo) {
		dataBase.insert_SQL(UserInfo);
	}
}
