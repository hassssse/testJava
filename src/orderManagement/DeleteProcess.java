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
  private int resultCount;
  private boolean deleted;

  public DeleteProcess(int orderNo) {
    conn = null;
    stmt = null;
    resultSet = null;
    resultCount = 0;
    setDeleted(false);
    sql1 = "DELETE FROM order_detail WHERE order_no = ?";
    sql2 = "DELETE FROM order_title WHERE order_no = ?";
    
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement(sql1);
      stmt.setInt(1, orderNo);
      stmt.executeUpdate();
      stmt = conn.prepareStatement(sql2);
      stmt.setInt(1, orderNo);
      resultCount = stmt.executeUpdate();
      if (resultCount!=0) setDeleted(true);
      
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
  
  public int getResultCount() {return resultCount;}
  public boolean isDeleted() {return deleted;}
  public void setDeleted(boolean deleted){this.deleted = deleted;};
  
}