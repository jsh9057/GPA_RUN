package Controller_Login;

import Controller_Media.Control_Media;
import DataBase.Control_DataBase;
import javafx.scene.media.MediaPlayer;

public class Control_Login {
	Control_DataBase dataBase = new Control_DataBase();
	Control_Media media = new Control_Media();
	MediaPlayer mediaplay;
	
	//////////////////Reference Controller_Media ////////////////
	
	//음악을 재생시켜주는 함수
	public void play_LoginPage_MediaPlayer(){
		mediaplay = media.getLoginPageBgm();
		mediaplay.play();
	}
	
	//음악을 점지시켜주는 함수
	public void stop_LoginPage_MediaPlayer() {
		mediaplay.stop();
	}
	
	/////////////////////Reference Database///////////////////////
	
	//현재 로그인상태를 데이터베이스에 업데이트하는 함수
	public void Update_login(String Name){
		dataBase.Update_LoginSQL(Name);
	}
	
	//현재아이디의 비밀번호가 맞는지 확인하는 함수
	public boolean select_PW(String _ID, String _PW) {
		String PW = dataBase.Select_Login_SQL(_ID);
		
		if(PW != null)
			return PW.equals(_PW);
		
		else
			return false;
		//return (PW.equals(_PW)) ? true : false;
	}

	//현재 ID가 중복이 되는지 확인하는 함수
	public boolean select_ID(String _ID) {
		String ID = dataBase.Select_Regist_SQL(_ID);
		return (ID == null) ? true : false;
	}

	//회원가입중 입력한 정보를 Database에 넣어주는 함수
	public void insert_UserInfo(String[] UserInfo) {
		dataBase.insert_SQL(UserInfo);
	}
}
