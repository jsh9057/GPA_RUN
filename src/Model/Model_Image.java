package Model;

import javafx.scene.image.Image;

public class Model_Image {
	Image jelly = new Image(getClass().getClassLoader().getResource("./ImageFile/Jelly_Image.png").toString(), true);
	Image F_High = new Image(getClass().getClassLoader().getResource("./ImageFile/F_High_Image.png").toString(), true);
	Image F_under = new Image(getClass().getClassLoader().getResource("./ImageFile/F_under_Image.png").toString(), true);
	public Image getJelly() {
		return jelly;
	}
	public Image getF_High() {
		return F_High;
	}
	public Image getF_under() {
		return F_under;
	}
	
}
