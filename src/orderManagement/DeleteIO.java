package orderManagement;

public class DeleteIO {
  public DeleteIO() {
    System.out.println("削除する受注No.を入力してください");
    int orderNumber = -1;
    while (orderNumber < 0) {
      System.out.print("受注No.:");
      orderNumber = Input.convertToInteger();
      if (orderNumber < 0) {
        Alert.incorrectNumber();
      }
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