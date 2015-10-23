package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectLike2 {
  Connection conn = null;
  PreparedStatement stmt = null;
  ResultSet resultSet = null;
  String sql;

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("検索したい住所を入力");
    String address = stdIn.next();

    SelectLike2 sl2 = new SelectLike2();

    try {
      sl2.conn = ConnectUtilMy.connectDatabase();
      sl2.stmt = sl2.conn.prepareStatement(sl2.sql);
      sl2.stmt.setString(1, "%"+address+"%");
      sl2.resultSet = sl2.stmt.executeQuery();
      while (sl2.resultSet.next()) {
        System.out.println("商品名:" + sl2.resultSet.getString("item_nam"));
        System.out.println("単価:" + sl2.resultSet.getDouble("price"));
        System.out.println("仕入先名:" + sl2.resultSet.getString("suppl_nam"));
        System.out.println();
      }
    }
    catch (SQLException ex) {
      testsqlexception(ex);
    }
    finally {
      testfinally(sl2.conn, sl2.stmt, sl2.resultSet);
    }
  }

  public SelectLike2() {

    sql = "SELECT item_nam, price, suppl_nam FROM item, suppl " +
          "WHERE suppl.suppl_c=item.suppl_c AND suppl_address LIKE ?";
  }

  private static void testsqlexception(SQLException ex) {
    System.out.println("エラーコード:" + ex.getErrorCode());
    System.out.println("SQL状態:" + ex.getSQLState());
    ex.printStackTrace();
  }

  private static void testfinally(Connection conn, PreparedStatement stmt, ResultSet resultSet) {
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