package orderManagement;

public class Alert {
  public static void fraudNumber() {
    System.out.println("入力データが不正です");
  }
  public static void emptySelect() {
    System.out.println("該当する顧客の受注は存在しません");
  }
  public static void resultDelete(boolean deleted) {
    if (deleted) System.out.println("受注を削除しました");
    else System.out.println("該当する受注No.は存在しません");
  }
}