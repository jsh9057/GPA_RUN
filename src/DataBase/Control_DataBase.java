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

	//받아온 User정보를 데이터베이스에 저장시키는 함수
	public void insert_SQL(String[] Data) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");
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

	//받아온 UserId에 점수를 업데이트시켜주는 함수
	public void Update_SQL(int Score, String id) {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");
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

	//데이터 베이스에 같은 아이디가 있는지 확인해주는 함수
	public String Select_Regist_SQL(String ID) {
		String Data = null;
		try {
			rs = null;
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");

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
	
	//데이터 베이스에 받아온 ID의 비밀번호를 받아 넘겨주는 함수
	public String Select_Login_SQL(String ID) {
		String Data = null;
		try {
			rs = null;
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");

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
	
	//데이터 베이스의 score Column을 내림차순으로 정렬후 첫번째, 두번째, 세번쨰의 id,name,score를 받아 보내주는 함수
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
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");
 
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
	
	//받아온 ID의 로그인 column value를 1로 업데이트 시켜주는 함수
	public void Update_LoginSQL(String ID) {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");
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
	
	//받아온 ID의 로그인 column value를 0로 업데이트 시켜주는 함수
	public void Update_LogoutSQL(String ID) {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");
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
	
	//현재 로그인 column이 1인 아이디의 id를 받아 넘겨주는 함수
	public String select_IDSQL(){
		String Data = null;
		try {
			rs = null;
			Class.forName(Driver);
			conn = DriverManager.getConnection(strconn, "gpa_user", "1009");
			if (conn == null)
				throw new Exception("데이터베이스를 연결할 수가 없습니다.");

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
