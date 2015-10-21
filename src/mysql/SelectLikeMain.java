package mysql;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * テーブル名やフィールド名に感知しない
 * SQL分に関知しない
 * SQLExceptionに関知しない
 */
public class SelectLikeMain {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("検索したい住所を入力（一部一致でも検索可）");
    String address = stdIn.next();
    SelectLikeSub sub = new SelectLikeSub(address);
    ArrayList<SelectLikeSub> subList = new ArrayList<SelectLikeSub>();

    for () {
      System.out.println("商品名:" + ("item_nam"));
      System.out.println("単価:" + ("price"));
      System.out.println("仕入先名:" + ("suppl_nam"));
      System.out.println();
    }

    //Connection conn = null;
    //PreparedStatement stmt = null;
    //ResultSet resultSet = null;

    /*try {
      resultSet = new SelectLikesub(address);
      while (resultSet.next()) {
        System.out.println("商品名:" + resultSet.getString("item_nam"));
        System.out.println("単価:" + resultSet.getDouble("price"));
        System.out.println("仕入先名:" + resultSet.getString("suppl_nam"));
        System.out.println();
      }
    }*/
    /*catch (SQLException ex) {
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
    }*/
  }
}