package orderManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectProcess {
  private ArrayList<SelectOrderResult> orderResultList = new ArrayList<SelectOrderResult>();
  private Connection conn;
  private PreparedStatement stmt, stmt2;
  private ResultSet resultSet, resultSet2;
  private String sql1, sql2;

  public SelectProcess(String customName) {
    conn = null;
    stmt = stmt2 = null;
    resultSet = resultSet2 = null;
    sql1 = "SELECT order_no, order_date, custom.custom_c, custom_nam, sales.sales_c, sales_nam"
         + " FROM order_title, custom, sales"
         + " WHERE custom.custom_c = order_title.custom_c"
         + " AND sales.sales_c = order_title.sales_c"
         + " AND custom_nam LIKE ?";

    sql2 = "SELECT item.item_c, item_nam, quantity"
         + " FROM item, order_detail"
         + " WHERE item.item_c = order_detail.item_c"
         + " AND order_no = ?";

    try {
      conn = ConnectDatabase.connectDatabase();
      stmt = conn.prepareStatement(sql1);
      stmt.setString(1, "%"+customName+"%");
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        SelectOrderResult orderResult = new SelectOrderResult();
        orderResult.setOrderNo(resultSet.getInt("order_no"));
        orderResult.setOrderDate(resultSet.getString("order_date"));
        orderResult.setCustomName(resultSet.getString("custom_nam"));
        orderResult.setCustomCode(resultSet.getInt("custom_c"));
        orderResult.setSalesName(resultSet.getString("sales_nam"));
        orderResult.setSalesCode(resultSet.getString("sales_c"));
        orderResultList.add(orderResult);

        stmt2 = conn.prepareStatement(sql2);
        stmt2.setInt(1, orderResult.getOrderNo());
        resultSet2 = stmt2.executeQuery();
        while (resultSet2.next()) {
          SelectOrderItemResult itemResult = new SelectOrderItemResult();
          itemResult.setItemCode(resultSet2.getInt("item_c"));
          itemResult.setItemName(resultSet2.getString("item_nam"));
          itemResult.setItemQuantity(resultSet2.getInt("quantity"));
          orderResult.getItemList().add(itemResult);
        }
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

  public ArrayList<SelectOrderResult> getOrderResultList(){return orderResultList;}
}