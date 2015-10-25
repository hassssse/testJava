package mysql;

import java.sql.*;

public class InsertParam {
  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    
    String sql = "INSERT INTO custom VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, 0);  //custom_c
      stmt.setString(2, "中臣　鎌足");  //custom_nam
      stmt.setString(3, "098-0980");  // custom_postal_c
      stmt.setString(4, "北海道天塩郡遠別町");  // custom_address
      stmt.setString(5, "090-1234-5678");  // custom_phon
      stmt.setDouble(6, 4700);  // total_bill
      stmt.setDouble(7, 124700);  // accum_amount
      stmt.setInt(8, 3);  // accum_times
      int resultCount = stmt.executeUpdate();
      
      System.out.println("INSERTにより追加された件数:"+resultCount+"件");
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