package orderManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Select {
  private ArrayList<SelectOrderResult> orderResultList = new ArrayList<SelectOrderResult>();
  private SelectOrderResult rslt;
  private Connection conn;
  private PreparedStatement stmt;
  private ResultSet resultSet;
  private String sql;

  public Select(String customName) {
    rslt = null;
    conn = null;
    stmt = null;
    resultSet = null;
    sql = "SELECT order_no, order_date, custom.custom_c, custom_nam, sales.sales_c, sales_nam"
        + " FROM order_title, custom, sales"
        + " WHERE custom.custom_c = order_title.custom_c"
        + " AND sales.sales_c = order_title.sales_c"
        + " AND custom_nam LIKE ?";

    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, "%"+customName+"%");
      resultSet = stmt.executeQuery();

      while (resultSet.next()) {
        rslt = new SelectOrderResult();
        rslt.setOrderNo(resultSet.getInt("order_no"));
        rslt.setOrderDate(resultSet.getString("order_date"));
        rslt.setCustomName(resultSet.getString("custom_nam"));
        rslt.setCustomCode(resultSet.getInt("custom_c"));
        rslt.setSalesName(resultSet.getString("sales_nam"));
        rslt.setSalesCode(resultSet.getString("sales_c"));
        orderResultList.add(rslt);
      }

      //sql = "SELECT order, item"
      //stmt = conn.prepareStatement(sql);

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

  public ArrayList<SelectOrderResult> getOrderResultList(){return orderResultList;}
}