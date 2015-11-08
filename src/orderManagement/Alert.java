package orderManagement;

public class Alert {
  public static void fraudNumber() {
    System.out.println("入力データが不正です");
  }
  
  public static void emptySelect() {
    System.out.println("該当する顧客の受注は存在しません");
  }
}