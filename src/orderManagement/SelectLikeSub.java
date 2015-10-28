package orderManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * 入出力の方式に関知しない
 */
public class SelectLikeSub {
  private ArrayList<Result> resultList = new ArrayList<Result>();
  private Result rslt;
  private Connection conn;
  private PreparedStatement stmt;
  private ResultSet resultSet;
  private String sql;

  public SelectLikeSub(String address) {
    rslt = null;
    conn = null;
    stmt = null;
    resultSet = null;
    sql = "SELECT item_nam, price, suppl_nam FROM item, suppl"
        + " WHERE suppl.suppl_c=item.suppl_c AND suppl_address LIKE ?";
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, "%"+address+"%");
      resultSet = stmt.executeQuery();

      while (resultSet.next()) {
        rslt = new Result();
        rslt.setItemName(resultSet.getString("item_nam"));
        rslt.setItemPrice(resultSet.getDouble("price"));
        rslt.setSupplName(resultSet.getString("suppl_nam"));
        resultList.add(rslt);
      }

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

  public ArrayList<Result> getResultList(){return resultList;}
}