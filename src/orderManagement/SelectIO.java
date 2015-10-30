package orderManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectIO {
  public SelectIO() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("顧客名（の一部）を入力してください");
    System.out.print("顧客名:");
    String customName = stdIn.next();
    System.out.println();
    
    SelectProcess select = new SelectProcess(customName);
    ArrayList<SelectOrderResult> orderList = select.getOrderResultList();
    
    if (!orderList.isEmpty()) {
      for (SelectOrderResult orderResult : orderList) {
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
      }
    } else Alert.emptySelect();
  }
}