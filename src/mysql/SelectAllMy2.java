package mysql;

import java.sql.*;

public class SelectAllMy2 {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    try {
      conn = ConnectUtilMy.connectDatabase();
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
    }	catch (SQLException ex) {
      System.out.println("エラーコード:" + ex.getErrorCode());
      System.out.println("SQL状態:" + ex.getSQLState());
      ex.printStackTrace();
    } finally {
      try {
        if (resultSet != null) {
          resultSet.close();
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
      try {
        if (stmt != null) {
          stmt.close();
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }
}
