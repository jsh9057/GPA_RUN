package Model;

public class Model_Game {
	public Model_Game(){
		setScore(0);
		setSpeed(5);
	}
	
	private double speed;
	private double score;
	private Boolean fever;
	
	public Boolean getFever() {
		return fever;
	}

	public void setFever(Boolean fever) {
		this.fever = fever;
	}
	
	public double getScore() {
		return score;
	}
	public void setScore(double _score) {
		if(this.score-_score<0){
			this.score=0;
		}
		this.score = _score;
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
