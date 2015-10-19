package mysql;

import java.sql.*;
/*
 * 商品テーブル中の，単価が 500 円未満で，かつ，
 * 仕入先コードが 4 の商品の商品名，単価，仕入先コードを表示する．
 */
public class SelectParam1 {
  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement("SELECT item_nam, price, suppl_c FROM item " +
                                   "WHERE price<? AND suppl_c=?");
      stmt.setInt(1, 500);
      stmt.setInt(2, 4);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        System.out.println("商品名:" + resultSet.getString("item_nam"));
        System.out.println("単価:" + resultSet.getDouble("price"));
        System.out.println("仕入れ先コード:" + resultSet.getInt("suppl_c"));
        System.out.println();
      }
    }
    catch (SQLException ex) {
      System.out.println("エラーコード:" + ex.getErrorCode());
      System.out.println("SQL状態:" + ex.getSQLState());
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