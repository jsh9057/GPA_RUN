package Controller_Game;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class splite_Image extends Transition {
	public Image Character_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/Character_Run_Image.png").toString(),true);
	public Image Sliding_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/Sliding.png").toString(),true);
	public Image fever_change_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/fever_chang.png").toString(),true);
	public Image fever_Image = new Image(getClass().getClassLoader().getResource("./ImageFile/fever.png").toString(),true);

	private ImageView imageView;
	private int count;
	private int columns;
	private int offsetX;
	private int offsetY;
	private int width;
	private int height;

	private int lastIndex;

	public splite_Image(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY,
			int width, int height, int fitHeight, int fitWidth, int locateX, int locateY) {
		imageView.setFitHeight(fitHeight);
		imageView.setFitWidth(fitWidth);
		imageView.relocate(locateX, locateY);
		this.imageView = imageView;
		this.count = count;
		this.columns = columns;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
	}

	public Animation seting_run_sprite(ImageView Character_ImageView, Animation Main_Character_Animation,
			splite_Image Main_Character_sprite) {
		Character_ImageView.setViewport(new Rectangle2D(0, 0, 155, 204));
		Main_Character_sprite.set_run(Character_ImageView);
		Main_Character_Animation = Main_Character_sprite;
		Main_Character_Animation.setCycleCount(Animation.INDEFINITE);
		return Main_Character_Animation;

	}

	private void set_run(ImageView Character_ImageView) {
		imageView.setFitHeight(126);
		imageView.setFitWidth(104);
		imageView.relocate(60, 250);
		Character_ImageView.setImage(Character_Image);
		imageView = Character_ImageView;
		count = 6;
		columns = 3;
		offsetX = 0;
		offsetY = 0;
		width = 155;
		height = 204;
		setCycleDuration(Duration.millis(350));
		setInterpolator(Interpolator.LINEAR);

	}
	public Animation seting_slide_sprite(ImageView Character_ImageView, Animation Main_Character_Animation,
			splite_Image Main_Character_sprite) {
		Character_ImageView.setViewport(new Rectangle2D(0, 0, 155, 204));
		Main_Character_sprite.set_slide(Character_ImageView);
		Main_Character_Animation = Main_Character_sprite;
		return Main_Character_Animation;

	}

	private void set_slide(ImageView Character_ImageView) {
		imageView.setFitHeight(126);
		imageView.setFitWidth(104);
		imageView.relocate(60, 320);
		Character_ImageView.setImage(Sliding_Image);
		imageView = Character_ImageView;
		count = 6;
		columns = 3;
		offsetX = 0;
		offsetY = 0;
		width = 155;
		height = 204;
		setCycleDuration(Duration.millis(500));
		setInterpolator(Interpolator.LINEAR);

	}
	public Animation seting_fever_sprite(ImageView Character_ImageView, Animation Main_Character_Animation,
			splite_Image Main_Character_sprite) {
		Character_ImageView.setViewport(new Rectangle2D(0, 0, 155, 204));
		Main_Character_sprite.set_fever(Character_ImageView);
		Main_Character_Animation = Main_Character_sprite;
		Main_Character_Animation.setCycleCount(Animation.INDEFINITE);
		return Main_Character_Animation;

	}

	private void set_fever(ImageView Character_ImageView) {
		imageView.setFitHeight(200);
		imageView.setFitWidth(150);
		imageView.relocate(60, 180);
		Character_ImageView.setImage(fever_Image);
		imageView = Character_ImageView;
		count = 6;
		columns = 3;
		offsetX = 0;
		offsetY = 0;
		width = 155;
		height = 204;
		setCycleDuration(Duration.millis(200));
		setInterpolator(Interpolator.LINEAR);

	}
	
	

	protected void interpolate(double k) {
		final int index = Math.min((int) Math.floor(k * count), count - 1);
		if (index != lastIndex) {
			final int x = (index % columns) * width + offsetX;
			final int y = (index / columns) * height + offsetY;
			imageView.setViewport(new Rectangle2D(x, y, width, height));
			lastIndex = index;
		}
	}
}