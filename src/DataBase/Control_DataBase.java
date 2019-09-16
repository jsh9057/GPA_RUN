package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Control_DataBase {
	private static Connection conn;
	private static String strconn = "jdbc:mysql://117.17.142.111:3306/GPA_DB?useUnicode=true&characterEncoding=utf8";
	private static String Driver = "com.mysql.jdbc.Driver";
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	//�޾ƿ� User������ �����ͺ��̽��� �����Ű�� �Լ�
	public void insert_SQL(String[] Data) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");
			pstmt = (PreparedStatement) conn
					.prepareStatement("INSERT INTO accountTB (id, pw, name, stnum, score) VALUES ('" + Data[0] + "','"
							+ Data[1] + "','" + Data[2] + "','" + Data[3] + "','0')");
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}

	}

	//�޾ƿ� UserId�� ������ ������Ʈ�����ִ� �Լ�
	public void Update_SQL(int Score, String id) {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");
			pstmt = (PreparedStatement) conn
					.prepareStatement("UPDATE accountTB  SET score = '" + Score + "' WHERE id = '" + id + "'");
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}
	}

	//������ ���̽��� ���� ���̵� �ִ��� Ȯ�����ִ� �Լ�
	public String Select_Regist_SQL(String ID) {
		String Data = null;
		try {
			rs = null;
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");

			pstmt = conn.prepareStatement("SELECT id from accountTB WHERE id = '" + ID + "'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Data = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}

		return Data;

	}
	
	//������ ���̽��� �޾ƿ� ID�� ��й�ȣ�� �޾� �Ѱ��ִ� �Լ�
	public String Select_Login_SQL(String ID) {
		String Data = null;
		try {
			rs = null;
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");

			pstmt = conn.prepareStatement("SELECT id, pw from accountTB WHERE id = '" + ID + "'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Data = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}
		return Data;

	}
	
	//������ ���̽��� score Column�� ������������ ������ ù��°, �ι�°, �������� id,name,score�� �޾� �����ִ� �Լ�
	public ArrayList<String[]> Select_Rank_SQL() {
		String[] Name = new String[20];
		String[] Score = new String[20];
		String[] ID = new String[20];
		int index = 0;
		try {
			rs = null;
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");
 
			pstmt = conn.prepareStatement("SELECT id, name, score from accountTB ORDER BY score DESC");
			rs = pstmt.executeQuery();
 
			while (rs.next()) {
				Name[index] = rs.getString("name");
				Score[index] = rs.getString("score");
				ID[index] = rs.getString("id");
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}
		ArrayList<String[]> list = new ArrayList<String[]>();
		list.add(ID);
		list.add(Name);
		list.add(Score);
		return list;
	}
	
	//�޾ƿ� ID�� �α��� column value�� 1�� ������Ʈ �����ִ� �Լ�
	public void Update_LoginSQL(String ID) {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");
			pstmt = (PreparedStatement) conn
					.prepareStatement("UPDATE accountTB  SET Login = 1 WHERE id = '" + ID + "'");
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}
	}
	
	//�޾ƿ� ID�� �α��� column value�� 0�� ������Ʈ �����ִ� �Լ�
	public void Update_LogoutSQL(String ID) {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");
			pstmt = (PreparedStatement) conn
					.prepareStatement("UPDATE accountTB  SET Login = 0 WHERE id = '" + ID + "'");
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}
	}
	
	//���� �α��� column�� 1�� ���̵��� id�� �޾� �Ѱ��ִ� �Լ�
	public String select_IDSQL(){
		String Data = null;
		try {
			rs = null;
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("�����ͺ��̽��� ������ ���� �����ϴ�.");

			pstmt = conn.prepareStatement("SELECT id from accountTB WHERE Login = 1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Data = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception sqle) {
				}
		}
		return Data;

	}
}
