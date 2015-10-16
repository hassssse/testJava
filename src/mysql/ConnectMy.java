package mysql;

import java.sql.*;

public class ConnectMy {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/orderdb?"
				+ "useUnicode=true&characterEncoding=WINDOWS-31J",
				"webdb", "webdb");
			System.out.println("データベース接続");
			conn.close();
			System.out.println("データベース切断");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
