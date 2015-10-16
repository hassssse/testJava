package mysql;

import java.sql.*;

public class SelectAllMy {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/orderdb?"
				+ "useUnicode=true&characterEncoding=WINDOWS-31J",
				"webdb", "webdb");
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM item ORDER BY price");
			while (resultSet.next()) {
				System.out.println("商品コード:" + resultSet.getInt("item_c"));
				System.out.println("商品分類コード:" + resultSet.getString("item_cat_c"));
				System.out.println("商品名:" + resultSet.getString("item_nam"));
				System.out.println("単価:" + resultSet.getDouble("price"));
				System.out.println("仕入れ先コード:" + resultSet.getInt("suppl_c"));
				System.out.println();
			}
		}
		catch (SQLException ex) {
			System.out.println("error code" + ex.getErrorCode());
			System.out.println("SQL state" + ex.getSQLState());
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
