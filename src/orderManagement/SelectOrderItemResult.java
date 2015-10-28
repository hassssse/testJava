package orderManagement;

public class SelectOrderItemResult {
  private String itemName;
  private int itemCode, itemQuantity;

  public String getItemName() {return itemName;}
  public int getItemCode() {return itemCode;}
  public int getItemQuantity() {return itemQuantity;}
  public void setItemName(String itemName) {this.itemName = itemName;}
  public void setItemCode(int itemCode) {this.itemCode = itemCode;}
  public void setItemQuantity(int itemQuantity) {this.itemQuantity = itemQuantity;}
}
