package orderManagement;

import java.util.Scanner;

public class DeleteIO {
  public DeleteIO() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("削除する受注No.を入力してください");
    System.out.println("受注No.:");
    int orderNo = stdIn.nextInt();
    DeleteProcess delete = new DeleteProcess(orderNo);

    /*for (SelectOrderResult orderResult : orderList) {
      System.out.println("受注No.:"+orderResult.getOrderNo());
      System.out.println("受注日付:"+orderResult.getOrderDate());
      System.out.println("顧客名:"+orderResult.getCustomName() + "("+orderResult.getCustomCode()+")");
      System.out.println("担当者名:"+orderResult.getSalesName() + "("+orderResult.getSalesCode()+")");
      System.out.println("受注商品一覧");
      for (SelectOrderItemResult itemResult : orderResult.getItemList()) {
        System.out.println(itemResult.getItemCode()
                          +"\t"+itemResult.getItemName()
                          +" : "+itemResult.getItemQuantity()+"個");
      }
      System.out.println();
    }*/
  }
}
