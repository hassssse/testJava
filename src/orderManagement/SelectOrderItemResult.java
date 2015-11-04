package orderManagement;

public class SelectOrderItemResult {
  private String itemName;
  private int itemCode, itemQuantity;

  public String getItemName() {
    return itemName;
  }
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
  public int getItemCode() {
    return itemCode;
  }
  public void setItemCode(int itemCode) {
    this.itemCode = itemCode;
  }
  public int getItemQuantity() {
    return itemQuantity;
  }
  public void setItemQuantity(int itemQuantity) {
    this.itemQuantity = itemQuantity;
  }


}
