package mysql;

import java.sql.*;
import java.util.Scanner;
/*
 * 検索条件とする単価の上限と下限を，ユーザに入力させる.
 */
public class SelectInput2 {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("検索条件を入力");
    System.out.print("単価の上限:");
    int priceUpper = stdIn.nextInt();
    System.out.print("単価の下限:");
    int priceLower = stdIn.nextInt();
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    try {
      conn = ConnectUtilMy.connectDatabase();
      stmt = conn.prepareStatement("SELECT item_nam, price, suppl_nam " +
                                   "FROM item, suppl " +
                                   "WHERE suppl.suppl_c=item.suppl_c " +
                                   "AND price<=? AND price>=?");
      stmt.setInt(1, priceUpper);
      stmt.setInt(2, priceLower);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        System.out.println("商品名:" + resultSet.getString("item_nam"));
        System.out.println("単価:" + resultSet.getDouble("price"));
        System.out.println("仕入先名:" + resultSet.getString("suppl_nam"));
        System.out.println();
      }
    }
    catch (SQLException ex) {
      System.out.println("エラーコード:" + ex.getErrorCode());
      System.out.println("SQL状態:" + ex.getSQLState());
      ex.printStackTrace();
    }
    finally {
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
}