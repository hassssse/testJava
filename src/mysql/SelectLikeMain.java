package mysql;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * テーブル名やフィールド名に感知しない
 * SQL分に関知しない
 * SQLExceptionに関知しない
 */
public class SelectLikeMain {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("検索したい住所を入力（一部一致でも検索可）");
    String address = stdIn.next();
    SelectLikeSub sub = new SelectLikeSub(address);
    ArrayList<Result> subList = sub.getResultList();
    
    for (Result result : subList) {
      System.out.println("商品名:"+result.getItemName());
      System.out.println("単価:"+result.getItemPrice());
      System.out.println("仕入先名:"+result.getSupplName());
      System.out.println();
    }
  }
}