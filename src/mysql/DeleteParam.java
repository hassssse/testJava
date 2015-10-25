package mysql;

import java.sql.*;

public class DeleteParam {
  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    
    String sql = "DELETE FROM custom WHERE custom_nam=?";
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement(sql);
      
      // 削除する条件
      stmt.setString(1, "中臣　鎌足");  //custom_nam
      int resultCount = stmt.executeUpdate();
      
      System.out.println("DELETEにより削除された件数:"+resultCount+"件");
    }
    catch (SQLException ex) {
      System.out.println("エラーコード:" + ex.getErrorCode());
      System.out.println("SQL状態:" + ex.getSQLState());
      ex.printStackTrace();
    }
    finally {
      try {
        if (resultSet != null) resultSet.close();
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }
      try {
        if (stmt != null) stmt.close();
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }
      try {
        if (conn != null) conn.close();
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }
}