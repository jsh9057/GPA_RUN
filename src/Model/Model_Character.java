package Model;

import javafx.scene.image.Image;

public class Model_Character {
	
	public Image Character_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/Character_Run_Image.png").toString(),true);
	public Image Sliding_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/Sliding.png").toString(),true);
	public Image fever_change_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/fever_chang.png").toString(),true);
	public Image fever_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/fever.png").toString(),true);
	public   int COLUMNS = 3; // 그림의 세로줄 갯수
	 public   int COUNT = 6; // 총그림 갯수
	 public   int OFFSET_X = 0; // 그림파일의 시작 좌표값
	 public   int OFFSET_Y = 0; // 그림파일의 시작 좌표값
	 public   int WIDTH = 155; // 한 칸당 이미지 크기
	 public   int HEIGHT = 204; // 한 칸당 이미지 크기
	public   int FITHEIGHT = 126;//68*2  136
	 public   int FITWIDTH = 104;  //52*2 104
	 public   int LOCATE_X = 50;
	 public   int LOCATE_Y = 255;
	 public void setCOLUMNS(int cOLUMNS) {
			COLUMNS = cOLUMNS;
		}
		public void setCOUNT(int cOUNT) {
			COUNT = cOUNT;
		}
		public void setOFFSET_X(int oFFSET_X) {
			OFFSET_X = oFFSET_X;
		}
		public void setOFFSET_Y(int oFFSET_Y) {
			OFFSET_Y = oFFSET_Y;
		}
		public void setWIDTH(int wIDTH) {
			WIDTH = wIDTH;
		}
		public void setHEIGHT(int hEIGHT) {
			HEIGHT = hEIGHT;
		}
		public void setFITHEIGHT(int fITHEIGHT) {
			FITHEIGHT = fITHEIGHT;
		}
		public void setFITWIDTH(int fITWIDTH) {
			FITWIDTH = fITWIDTH;
		}
		public void setLOCATE_X(int lOCATE_X) {
			LOCATE_X = lOCATE_X;
		}
		public void setLOCATE_Y(int lOCATE_Y) {
			LOCATE_Y = lOCATE_Y;
		}
	
	public  int getColumns() {
		return COLUMNS;
	}
	public  int getCount() {
		return COUNT;
	}
	public  int getOffsetX() {
		return OFFSET_X;
	}
	public  int getOffsetY() {
		return OFFSET_Y;
	}
	public  int getWidth() {
		return WIDTH;
	}
	public  int getHeight() {
		return HEIGHT;
	}
	public  int getFitheight() {
		return FITHEIGHT;
	}
	public  int getFitwidth() {
		return FITWIDTH;
	}
	public  int getLocateX() {
		return LOCATE_X;
	}
	public  int getLocateY() {
		return LOCATE_Y;
	}
	public Image getCharacter_Image() {
		return Character_Image;
	}
	public void setCharacter_Image(Image character_Image) {
		Character_Image = character_Image;
	}

}
