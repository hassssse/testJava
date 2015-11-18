package orderManagement;

import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class Alert {
  public static void incorrectNumber() {
    System.out.println("入力データが不正です");
  }

  public static void sqlError(SQLException e) {
    System.out.println("エラーコード:" + e.getErrorCode());
    System.out.println("SQL状態:" + e.getSQLState());
    e.printStackTrace();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
  }

  public static void sqlIntegrityConstraintViolation(MySQLIntegrityConstraintViolationException e) {
    sqlError(e);
    System.out.println("受注を正しく登録できませんでした");
  }
}