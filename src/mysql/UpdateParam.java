package mysql;

import java.sql.*;

public class UpdateParam {
  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    
    String sql = "UPDATE custom SET custom_postal_c=?, custom_address=?, custom_phon=?"
               + " WHERE custom_c=? AND custom_nam=?";
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement(sql);
      
      // 変更内容
      stmt.setString(1, "098-0980");  // custom_postal_c
      stmt.setString(2, "北海道稚内市宗谷岬");  // custom_address
      stmt.setString(3, "01632-2-3610");  // custom_phon
      // 変更する条件
      stmt.setInt(4, 6);  //custom_c
      stmt.setString(5, "中臣　鎌足");  //custom_nam
      int resultCount = stmt.executeUpdate();
      
      System.out.println("UPDATEにより変更された件数:"+resultCount+"件");
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