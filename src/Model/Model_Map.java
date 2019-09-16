package Model;

public class Model_Map {
	private int[] stage1 = {1,1,4,5,1,2,4,5,2,2,1,1,1,1,1,4,5,1,2,4,5,2,2,1,1,1,1,1,4,5,1,2,4,5,2,2,1,1,1,0};//1,1,4,5,1,2,4,5,2,2,1,1,1
	private int[] stage2 = {};
	private int[] stage3 = {};
	private int JellyLocationX;
	private int JellyLocationY;
	private int FLocationX;
	private int FLocationY;
	
	
	public int getFLocationX() {
		return FLocationX;
	}
	public void setFLocationX(int fLocationX) {
		FLocationX = fLocationX;
	}
	public int getFLocationY() {
		return FLocationY;
	}
	public void setFLocationY(int fLocationY) {
		FLocationY = fLocationY;
	}
	public int getImageLocationX() {
		return JellyLocationX;
	}
	public void setImageLocationX(int imageLocationX) {
		JellyLocationX = imageLocationX;
	}
	public int getImageLocationY() {
		return JellyLocationY;
	}
	public void setImageLocationY(int imageLocationY) {
		JellyLocationY = imageLocationY;
	}
	public int[] getStage1() {
		return stage1;
	}
	public void setStage1(int[] stage1) {
		this.stage1 = stage1;
	}
	public int[] getStage2() {
		return stage2;
	}
	public void setStage2(int[] stage2) {
		this.stage2 = stage2;
	}
	public int[] getStage3() {
		return stage3;
	}
	public void setStage3(int[] stage3) {
		this.stage3 = stage3;
	}
}
