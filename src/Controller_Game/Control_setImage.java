package Controller_Game;

import Model.ArrayList_Return;
import Model.Model_Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Control_setImage {
	Model_Map model_Map = new Model_Map();
	ArrayList_Return rt = new ArrayList_Return();

	/////////////////////////////////////// Model_map에 저장되있는 Map의 정보의 따라 객체 생성 및 위치 조절 ////////////////////////////////////////
	
	//MapData를 읽고 분류해주는 함수
	public ArrayList_Return setImageView(Image jelly, Image F_High, Image F_under) {
		int i = 0;
		while (i < model_Map.getStage1().length) {
			switch (model_Map.getStage1()[i]) {
			case 0:
				setImage_Paten0(jelly);
				break;
			case 1:
				setImage_Paten1(jelly);
				break;
			case 2:
				setImage_Paten2(jelly, F_High);
				break;
			case 3:
				setImage_Paten3(jelly, F_under);
				break;
			case 4:
				setImage_Paten4(jelly, F_under);
				break;
			case 5:
				setImage_Paten5(jelly);
				break;
			case 6:
				setImage_Paten6(F_under);
				break;
			}
			i++;
		}
		return rt;
	}

	// 마지막 게임 종료하는 jelly
	public void setImage_Paten0(Image jelly) {
		ImageView image_A = new ImageView(jelly);
		image_A.setLayoutX(800 + model_Map.getImageLocationX() + image_A.getFitWidth());
		image_A.setLayoutY(170);
		image_A.setFitWidth(300);
		image_A.setFitHeight(200);
		model_Map.setImageLocationX(model_Map.getImageLocationX() + 35);
		rt.ImageLastList.add(image_A);
	}

	// 일직선 jelly만 나오는 paten
	public void setImage_Paten1(Image jelly) {
		int i = 0;
		while (i < 5) {
			ImageView image_A = new ImageView(jelly);
			image_A.setLayoutX(800 + model_Map.getImageLocationX() + image_A.getFitWidth());
			image_A.setLayoutY(300);
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 35);
			rt.ImageJellyList.add(image_A);
			i++;
		}
	}

	// bottom jelly && High F
	public void setImage_Paten2(Image jelly, Image F_High) {
		int i = 0;
		int j = 0;
		while (j < 6) {
			ImageView image_A = new ImageView(jelly);
			image_A.setLayoutX(600 + model_Map.getImageLocationX() + image_A.getFitWidth() + 240);
			image_A.setLayoutY(330);
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 40);
			rt.ImageJellyList.add(image_A);
			j++;
		}
		while (i < 3) {
			ImageView image_B = new ImageView(F_High);
			image_B.setLayoutX(600 + model_Map.getImageLocationX() + image_B.getFitWidth());
			image_B.setLayoutY(-20);
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 80);
			rt.ImageF_HighList.add(image_B);
			i++;
		}
	}

	public void setImage_Paten3(Image jelly, Image F_under) {
		int i = 0;
		while (i < 5) {
			ImageView image_A = new ImageView(jelly);
			image_A.setLayoutX(800 + model_Map.getImageLocationX() + image_A.getFitWidth());
			image_A.setLayoutY(330);
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 35);
			rt.ImageJellyList.add(image_A);
			i++;
		}
		int j = 0;
		while (j < 1) {
			ImageView image_B = new ImageView(F_under);
			image_B.setLayoutX(800 + model_Map.getImageLocationX() + image_B.getFitWidth());
			image_B.setLayoutY(330);
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 35);
			rt.ImageF_underList.add(image_B);
			j++;
		}
	}

	// 오르락
	public void setImage_Paten4(Image jelly, Image F_under) {
		int i = 0;
		while (i < 5) {
			ImageView image_A = new ImageView(jelly);
			image_A.setLayoutX(800 + model_Map.getImageLocationX() + image_A.getFitWidth());
			image_A.setLayoutY(280 - model_Map.getImageLocationY());
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 35);
			model_Map.setImageLocationY(model_Map.getImageLocationY() + 30);
			rt.ImageJellyList.add(image_A);
			i++;
		}

		ImageView image_B = new ImageView(F_under);
		image_B.setLayoutX(800 + model_Map.getImageLocationX() + image_B.getFitWidth());
		image_B.setLayoutY(330);
		rt.ImageF_underList.add(image_B);
	}

	// 내리락
	public void setImage_Paten5(Image jelly) {
		int i = 0;
		while (i < 5) {
			ImageView image_A = new ImageView(jelly);
			image_A.setLayoutX(800 + model_Map.getImageLocationX() + image_A.getFitWidth());
			image_A.setLayoutY(280 - model_Map.getImageLocationY());
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 35);
			model_Map.setImageLocationY(model_Map.getImageLocationY() - 30);
			rt.ImageJellyList.add(image_A);
			i++;
		}
	}

	public void setImage_Paten6(Image F_under) {
		int i = 0;
		while (i < 5) {
			ImageView image_A = new ImageView(F_under);
			image_A.setLayoutX(800 + model_Map.getImageLocationX() + image_A.getFitWidth());
			image_A.setLayoutY(280 - model_Map.getImageLocationY());
			model_Map.setImageLocationX(model_Map.getImageLocationX() + 35);
			model_Map.setImageLocationY(model_Map.getImageLocationY() - 30);
			rt.ImageF_underList.add(image_A);
			i++;
		}
	}
}
