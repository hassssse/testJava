package orderManagement;

import java.util.Scanner;

public class DeleteIO {
  public DeleteIO() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("削除する受注No.を入力してください");
    System.out.print("受注No.:");
    int orderNumber = stdIn.nextInt();
    if (orderNumber<0) {
      Alert.fraudNumber();
    }
    DeleteProcess delete = new DeleteProcess();
    delete.deleteOrderByOrderNumber(orderNumber);
    if (delete.hasDeleted()) {
      System.out.println("受注を削除しました");
    } else {
      System.out.println("該当する受注No.は存在しません");
    }
    System.out.println();
  }
}
