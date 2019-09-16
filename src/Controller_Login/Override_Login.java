package Controller_Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Override_Login implements Initializable{
	
	Control_Login control = new Control_Login();	//Event Class
	
	@FXML StackPane Login_stackPane;
	/////////////////////Login_Override/////////////////////////
	@FXML Pane Login_pane;
	@FXML Button Login_signUp_Btn;
	@FXML TextField Login_ID_Textfield;
	@FXML PasswordField Login_PW_Textfield;
	@FXML Button Login_login_Btn;
	@FXML Label Login_Overlap_Label;
	
	///////////////////signUp_Override///////////////////////
	@FXML Pane signUP_pane;
	@FXML TextField signUP_ID_Textfield;
	@FXML PasswordField signUP_PW_Textfield;
	@FXML TextField signUP_Name_Textfield;
	@FXML TextField signUP_studentNum_Textfield;
	@FXML CheckBox signUP_Agree_CheckBox;
	@FXML Button signUP_signUp_Btn;
	@FXML Label signUP_Overlap_Label;
	@FXML Button signUP_Overlap_Btn;
	@FXML Button signUP_Cancle_Btn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		signUP_pane.setVisible(false);
		signUP_signUp_Btn.setDisable(true);
		signUP_Overlap_Label.setVisible(false);
		signUP_Overlap_Label.setTextFill(Color.RED);
		Login_Overlap_Label.setVisible(false);
		control.play_LoginPage_MediaPlayer();
		
		//�α���ȭ�鿡�� ȸ������ ��ư�� �������� �α���ȭ���� ����� ȸ������ ȭ���� �����ִ� �Լ�
		Login_signUp_Btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				signUP_pane.setVisible(true);
				Login_pane.setVisible(false);
			}
		});
		
		//�α��� ȭ�鿡�� �α��ι�ư�� �������� ���� �Է��� ID�� PW�� �´� �������� Ȯ���� Ʋ������� �ٽ� �Է��϶�� Label�� ������ ���� ��� Informationȭ������ �Ѿ�� �Լ�
		Login_login_Btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String ID = Login_ID_Textfield.getText();
				String PW = Login_PW_Textfield.getText();
				if(control.select_PW(ID, PW))
				{
					control.Update_login(ID);
					control.stop_LoginPage_MediaPlayer();
					try {
						Parent Information = FXMLLoader.load(getClass().getClassLoader().getResource("_View/Information_Page.fxml"));
						Login_stackPane = (StackPane)Login_login_Btn.getScene().getRoot();
						Login_stackPane.getChildren().clear();
						Login_stackPane.getChildren().add(Information);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				else{
					Login_Overlap_Label.setVisible(true);
					Login_Overlap_Label.setTextFill(Color.RED);
					Login_Overlap_Label.setText("���̵� �Ǵ� ��й�ȣ�� Ȯ���Ͻÿ�.");
				}
			}
		});
		
		//ȸ������ ȭ�鿡�� �Է��� ID�� �ߺ��Ǵ� ���̵����� Ȯ���ϴ� �Լ�
		signUP_Overlap_Btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(control.select_ID(signUP_ID_Textfield.getText())){
					signUP_Overlap_Label.setVisible(true);
					signUP_Overlap_Label.setText("��� ������ ���̵��Դϴ�.");
					signUP_Overlap_Label.setTextFill(Color.BLACK);
				}
				else{
					signUP_Overlap_Label.setVisible(true);
					signUP_Overlap_Label.setText("��� �Ұ����� ���̵��Դϴ�.");
					signUP_Overlap_Label.setTextFill(Color.RED);
				}
				
			}
		});
		
		//ȸ������ ȭ�鿡�� �����ϱ� ���� �Է��� �������� ���Ǹ� �޴� CheckBox�� check���ؾ� ȸ������ ��ư�� Ȱ��ȭ��Ű�� �Լ�
		signUP_Agree_CheckBox.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(signUP_signUp_Btn.isDisable())
					signUP_signUp_Btn.setDisable(false);
				else
					signUP_signUp_Btn.setDisable(true);
			}
		});
		
		//ȸ������ ȭ�鿡�� �Է��� ������ DataBase�� �����ָ� Loginȭ���� �����ִ� �Լ�
		signUP_signUp_Btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String[] sendData_to_DataBase = new String[4];
				sendData_to_DataBase[0] = new String(signUP_ID_Textfield.getText());
				sendData_to_DataBase[1] = new String(signUP_PW_Textfield.getText());
				sendData_to_DataBase[2] = new String(signUP_Name_Textfield.getText());
				sendData_to_DataBase[3] = new String(signUP_studentNum_Textfield.getText());
				if(signUP_Overlap_Label.getTextFill() == Color.RED){
					signUP_Overlap_Label.setText("�ߺ�Ȯ��üũ�� �Ͻʽÿ�.");
					signUP_Overlap_Label.setVisible(true);
				}
				else{
					control.insert_UserInfo(sendData_to_DataBase);
					Login_pane.setVisible(true);
					signUP_pane.setVisible(false);
				}
			}
		});
		
		//ȸ������ ȭ�鿡�� ��ҹ�ư�� �������� �ٽ� �α���ȭ������ �Ѿ�� �Լ�
		signUP_Cancle_Btn.setOnAction(event->{
			signUP_pane.setVisible(false);
			Login_pane.setVisible(true);
		});
	}
}
