package Controller_Ending;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
 
public class Control_Ending {
	
public void Aplus_move(ImageView a_plus) {
	{
		
		Timeline tml1 = new Timeline();
		KeyFrame Aplus = new KeyFrame(Duration.seconds(2),
				new KeyValue(a_plus.translateXProperty(), -435),
				new KeyValue(a_plus.translateYProperty(), 0));
		tml1.getKeyFrames().add(Aplus);
		tml1.play();
		
	}
	
}
}
 