package orderManagement;

import java.util.ArrayList;

public class Temp {
  public Temp() {
    System.out.println("class Temp");
    System.out.println("Test of selectProcess\n");
    SelectProcess select;
    
    System.out.println("Test -> selectCustomListAll");
    select = new SelectProcess();
    select.selectCustomListAll();
    ArrayList<SelectCustomResult> customList = select.getCustomResultList();
    for (int i=0; i<customList.size(); i++) {
      System.out.println(i+1 + " " + customList.get(i).getCustomName()
        + " (" + customList.get(i).getCustomCode() + ")");
    }
    int indexCustom = Input.convertToInteger();
    if (checkCorrectNumber(indexCustom, customList.size())) {
      System.out.println("コード:" + customList.get(indexCustom-1).getCustomCode());
      System.out.println();
    } else {
      Alert.incorrectNumber();
      System.out.println();
    }
    
    System.out.println("Test -> selectSalesListAll");
    select = new SelectProcess();
    select.selectSalesListAll();
    ArrayList<SelectSalesResult> salesList = select.getSalesResultList();
    for (int i=0; i<salesList.size(); i++) {
      System.out.println(i+1 + " " + salesList.get(i).getSalesName()
        + " (" + salesList.get(i).getSalesCode() + ")");
    }
    int indexSales = Input.convertToInteger();
    if (checkCorrectNumber(indexSales, salesList.size())) {
      System.out.println("コード:" + salesList.get(indexSales-1).getSalesCode());
      System.out.println();
    } else {
      Alert.incorrectNumber();
      System.out.println();
    }
    
    System.out.println("Test -> selectItemListAll");
    select = new SelectProcess();
    select.selectItemListAll();
    ArrayList<SelectItemResult> itemList = select.getItemResultList();
    for (int i=0; i<itemList.size(); i++) {
      System.out.println(i+1 + " " + itemList.get(i).getItemName()
        + " (" + itemList.get(i).getItemCode() + ")");
    }
    int indexItem = Input.convertToInteger();
    if (checkCorrectNumber(indexItem, itemList.size())) {
      System.out.println("コード:" + itemList.get(indexItem-1).getItemCode());
      System.out.println();
    } else {
      Alert.incorrectNumber();
      System.out.println();
    }
  }
  
  public boolean checkCorrectNumber (int index, int size) {
    if (0 < index && index <= size) {
      return true;
    } else {
      return false;
    }
  }
}