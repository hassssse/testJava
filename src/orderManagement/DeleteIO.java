package orderManagement;

import java.util.Scanner;

public class DeleteIO {
  public DeleteIO() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("削除する受注No.を入力してください");
    System.out.println("受注No.:");
    int orderNo = stdIn.nextInt();
    if (orderNo<0) Alert.fraudNumber();
    DeleteProcess delete = new DeleteProcess(orderNo);
    if (delete.hasDeleted()) {
      System.out.println("受注を削除しました");
    } else {
      System.out.println("該当する受注No.は存在しません");
    }
  }
}
