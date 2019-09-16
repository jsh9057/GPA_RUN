package Model;

public class Model_Login {
	public Model_Login(String userID, String userName) {
		this.userID = userID;
		this.userName = userName;
	}
	private String userID;
	private String userName;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
