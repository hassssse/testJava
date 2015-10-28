package orderManagement;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int num = -1;
    while(num != 0) {
      System.out.println("処理を選択してください");
      System.out.println("1 受注検索");
      System.out.println("2 受注登録");
      System.out.println("3 受注削除");
      System.out.println("0 終了");
      System.out.print("番号:");
      num = stdIn.nextInt();

      switch(num) {
      case 1:
        // 検索
        break;
      case 2:
        // 登録
        break;
      case 3:
        // 削除
        break;
      case 0:
        break;
      default:
        System.out.println("不正");
      }
    }
  }
}
