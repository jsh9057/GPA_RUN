package Controller_Ending_Credit;

import Controller_Game.splite_Image;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Controller_Ending_Credit {

	public void move_endingcredit (ImageView endingcredit) {

		Timeline tml1 = new Timeline();
		
		KeyFrame moveback1 = new KeyFrame(Duration.seconds(20),
				new KeyValue(endingcredit.translateXProperty(), 0),
				new KeyValue(endingcredit.translateYProperty(), -1500));
		tml1.getKeyFrames().add(moveback1);
		tml1.play();

	}
	
	public Animation run_endingcredit(ImageView Game_Maincharacter_ImageView){
		Game_Maincharacter_ImageView.setViewport(new Rectangle2D(0, 0,
				200, 100));
		final Animation Main_Character = new splite_Image(Game_Maincharacter_ImageView, Duration.millis(350),
				6, 3, 0,0,
				155,204,126,104,
				50,300);
		Main_Character.setCycleCount(Animation.INDEFINITE);
		Game_Maincharacter_ImageView.setLayoutX(130);
		Game_Maincharacter_ImageView.setLayoutY(200);
		return Main_Character;
	}

}
