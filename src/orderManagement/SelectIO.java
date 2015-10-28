package orderManagement;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * テーブル名やフィールド名に感知しない
 * SQL分に関知しない
 * SQLExceptionに関知しない
 */
public class SelectIO {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("顧客名（の一部）を入力してください");
    String customName = stdIn.next();
    Select select = new Select(customName);
    ArrayList<SelectOrderResult> orderList = select.getOrderResultList();

    for (SelectOrderResult result : orderList) {
      System.out.println("受注No.:"+result.getOrderNo());
      System.out.println("受注日付:"+result.getOrderDate());
      System.out.println("顧客名:"+result.getCustomName() + "("+result.getCustomCode()+")");
      System.out.println("担当者名:"+result.getSalesName() + "("+result.getSalesCode()+")");
      System.out.println("受注商品一覧");
      for (SelectOrderItemResult itemResult : result.getItemList()) {
        System.out.println(itemResult.getItemCode()
                          +"\t"+itemResult.getItemName()
                          +":"+itemResult.getItemQuantity()+"個");
      }
      System.out.println();
    }
  }
}