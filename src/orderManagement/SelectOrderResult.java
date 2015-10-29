package orderManagement;

import java.util.ArrayList;

public class SelectOrderResult {
  private String orderDate, customName, salesName, salesCode;
  private int orderNo, customCode;
  //private SelectOrderItemResult item;
  private ArrayList<SelectOrderItemResult> itemList;

  // constructor
  public SelectOrderResult() {
    //item  = new SelectOrderItemResult();
    itemList = new ArrayList<SelectOrderItemResult>();
  }
  
  // getter, setter
  public String getOrderDate() {return orderDate;}
  public String getCustomName() {return customName;}
  public String getSalesName() {return salesName;}
  public String getSalesCode() {return salesCode;}
  public int getOrderNo() {return orderNo;}
  public int getCustomCode() {return customCode;}
  //public SelectOrderItemResult getItem() {return item;}
  public ArrayList<SelectOrderItemResult> getItemList() {return itemList;}
  public void setOrderDate(String orderDate) {this.orderDate = orderDate;}
  public void setCustomName(String customName) {this.customName = customName;}
  public void setSalesCode(String salesCode) {this.salesCode = salesCode;}
  public void setSalesName(String salesName) {this.salesName = salesName;}
  public void setOrderNo(int orderNo) {this.orderNo = orderNo;}
  public void setCustomCode(int customCode) {this.customCode = customCode;}
  //public void setItem(SelectOrderItemResult item) {this.item = item;}
  public void setItemList(ArrayList<SelectOrderItemResult> itemList) {this.itemList = itemList;}

}