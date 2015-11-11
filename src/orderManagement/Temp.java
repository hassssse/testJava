package orderManagement;

import java.util.ArrayList;

public class Temp {
  public Temp() {
    System.out.println("class Temp");
    System.out.println("Test of selectProcess\n");
    SelectProcess select;


    // 顧客の一覧を表示
    System.out.println("Test -> selectCustomListAll");
    select = new SelectProcess();
    select.selectCustomListAll();
    ArrayList<SelectCustomResult> customList = select.getCustomResultList();
    for (int i=0; i<customList.size(); i++) {
      System.out.printf("%-2d ", i+1);
      System.out.printf("%s", customList.get(i).getCustomName());
      System.out.printf("(%s)", customList.get(i).getCustomCode());
      System.out.println();
    }

    // 通し番号から顧客コードを取得
    int indexCustom = Input.convertToInteger();
    if (checkCorrectNumber(indexCustom, customList.size())) {
      System.out.println("コード:" + customList.get(indexCustom-1).getCustomCode());
    } else {
      Alert.incorrectNumber();
    }
    System.out.println();


    // 担当者の一覧を表示
    System.out.println("Test -> selectSalesListAll");
    select = new SelectProcess();
    select.selectSalesListAll();
    ArrayList<SelectSalesResult> salesList = select.getSalesResultList();
    for (int i=0; i<salesList.size(); i++) {
      System.out.printf("%-2d ", i+1);
      System.out.printf("%s", salesList.get(i).getSalesName());
      System.out.printf("(%s)", salesList.get(i).getSalesCode());
      System.out.println();
    }

    // 通し番号から担当者コードを取得
    int indexSales = Input.convertToInteger();
    if (checkCorrectNumber(indexSales, salesList.size())) {
      System.out.println("コード:" + salesList.get(indexSales-1).getSalesCode());
    } else {
      Alert.incorrectNumber();
    }
    System.out.println();


    // 商品の一覧を表示
    System.out.println("Test -> selectItemListAll");
    select = new SelectProcess();
    select.selectItemListAll();
    ArrayList<SelectItemResult> itemList = select.getItemResultList();
    for (int i=0; i<itemList.size(); i++) {
      String name = itemList.get(i).getItemName();
      for (int j=0; j<15; j++) {
        name += "　";
      }
      System.out.printf("%3d ", i+1);
      System.out.printf("%.14s", name);
      System.out.printf("(%3d)", itemList.get(i).getItemCode());
      if (i%2==0) {
        System.out.print("\t");
      } else {
        System.out.println();
      }
    }

    // 通し番号から商品コードを取得する
    int indexItem = Input.convertToInteger();
    if (checkCorrectNumber(indexItem, itemList.size())) {
      System.out.println("コード:" + itemList.get(indexItem-1).getItemCode());
      System.out.println("価格:" + itemList.get(indexItem-1).getItemPrice());
      System.out.println();
    } else {
      Alert.incorrectNumber();
      System.out.println();
    }

    /*
    select = new SelectProcess();
    select.selectOrderListAll();
    */
  }

  public boolean checkCorrectNumber (int index, int size) {
    if (0 < index && index <= size) {
      return true;
    } else {
      return false;
    }
  }
}