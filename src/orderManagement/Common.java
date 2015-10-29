package orderManagement;

public class Common {
  public static void alertFraudNumber() {
    System.out.println("入力データが不正です");
  }
  public static void alertEmptySelect() {
    System.out.println("該当する顧客の受注は存在しません");
  }
  public static void alertResultDelete(boolean deleted) {
    if (deleted) System.out.println("受注を削除しました");
    else System.out.println("該当する受注No.は存在しません");
  }
}