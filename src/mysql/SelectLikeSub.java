package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * 入出力の方式に関知しない
 */
public class SelectLikeSub {
  //ArrayList<ResultSet> resultList = new ArrayList<ResultSet>();
  ArrayList<OneResult> resultList = new ArrayList<OneResult>();
  ArrayList<String> showList = new ArrayList<String>();
  OneResult aResult = null;

  public SelectLikeSub(String address) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement("SELECT item_nam, price, suppl_nam " +
                                   "FROM item, suppl " +
                                   "WHERE suppl.suppl_c=item.suppl_c " +
                                   "AND suppl_address LIKE ?");
      stmt.setString(1, "%"+address+"%");
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        aResult = new OneResult(resultSet);
        resultList.add(aResult);
      }
      for (OneResult aResult : resultList){
        aResult;
      }
    } catch (SQLException ex) {
      System.out.println("エラーコード:" + ex.getErrorCode());
      System.out.println("SQL状態:" + ex.getSQLState());
      ex.printStackTrace();
    } finally {
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

  public void show() {
    String str="";
    str+=
  }
}