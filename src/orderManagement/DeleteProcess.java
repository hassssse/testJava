package orderManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteProcess {
  private Connection conn;
  private PreparedStatement stmt;
  private ResultSet rslt;
  private int resultCount;
  private boolean hasDeleted;

  public DeleteProcess() {
    init();
    conn = ConnectDB.connectDatabase();
  }
  
  // getter
  public int getResultCount() {
    return resultCount;
  }
  
  public boolean hasDeleted() {
    return hasDeleted;
  }  
  
  //初期化
  public void init() {
    conn = null;
    stmt = null;
    rslt = null;
    resultCount = 0;
    hasDeleted = false;
  }
  
  // クローズ
  public void close() {
    try {
      if (rslt != null) {
        rslt.close();
      }
    } catch (SQLException e) {
      sqlError(e);;
    }
    try {
      if (stmt != null) {
        stmt.close();
      }
    } catch (SQLException e) {
      sqlError(e);
    }
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (SQLException e) {
      sqlError(e);
    }
   }
  
  // sqlの例外処理
  public void sqlError(SQLException e) {
    System.out.println("エラーコード:" + e.getErrorCode());
    System.out.println("SQL状態:" + e.getSQLState());
    e.printStackTrace();
    Alert.incorrectNumber();
  }
  
  public void deleteOrderByOrderNumber(int orderNumber) {
    String sql1,sql2;
    sql1 = "DELETE FROM order_detail WHERE order_no = ?";
    sql2 = "DELETE FROM order_title WHERE order_no = ?";
    try {
      stmt = conn.prepareStatement(sql1);
      stmt.setInt(1, orderNumber);
      stmt.executeUpdate();
      stmt = conn.prepareStatement(sql2);
      stmt.setInt(1, orderNumber);
      resultCount = stmt.executeUpdate();
      if (resultCount!=0) {
        hasDeleted = true;
      }
    } catch (SQLException e) {
      sqlError(e);
    } finally {
      close();
    }
  }
}