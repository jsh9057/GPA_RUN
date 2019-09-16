package Controller_Rank;

import java.util.ArrayList;

import DataBase.Control_DataBase;

public class Control_Rank {
	Control_DataBase dataBase = new Control_DataBase();
	ArrayList<String[]> list = dataBase.Select_Rank_SQL();
	String id;
	
	// ������ DataBase�� ��������ִ� �Լ�
	public void update_scoreRank(int Score){
		id = dataBase.select_IDSQL();
		dataBase.Update_SQL(Score, id);
	}
	
	// �α׾ƿ� �����ִ� �Լ�
	public void Logout(){
		dataBase.Update_LogoutSQL(id);
	}

	// 1,2,3���� �̸�, ���̵� ���� �Լ�
	public String[] select_nameRank() {
		String[] ID = list.get(0);
		String[] Name = list.get(1);
		String[] Rank = new String[3];
		Rank[0] = Name[0] + "(" + ID[0] + ")";
		Rank[1] = Name[1] + "(" + ID[1] + ")";
		Rank[2] = Name[2] + "(" + ID[2] + ")";
		return Rank;
	}
	
	// 1,2,3���� ���� ���� �Լ�
	public String[] select_scoreRank() {
		String[] score = list.get(2);
		String[] Rank = new String[3];
		Rank[0] = score[0];
		Rank[1] = score[1];
		Rank[2] = score[2];
		return Rank;
	}

}
