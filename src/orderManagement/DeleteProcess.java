package orderManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.ConnectUtilMy;

public class DeleteProcess {
  private Connection conn;
  private PreparedStatement stmt;
  private ResultSet resultSet;
  private String sql1, sql2;

  public DeleteProcess(int orderNo) {
    conn = null;
    stmt = null;
    resultSet = null;
    sql1 = "DELETE FROM order_detail WHERE order_no = ?";
    sql2 = "DELETE FROM order_title WHERE order_no = ?";
    
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement(sql1);
      stmt.setInt(1, orderNo);
      stmt.executeUpdate();
      stmt = conn.prepareStatement(sql2);
      stmt.setInt(1, orderNo);
      stmt.executeUpdate();
      
    } catch (SQLException ex) {
      System.out.println("エラーコード:" + ex.getErrorCode());
      System.out.println("SQL状態:" + ex.getSQLState());
      ex.printStackTrace();
    } finally {
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
